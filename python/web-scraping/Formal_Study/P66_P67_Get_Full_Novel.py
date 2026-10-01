import re
import time
import random
import asyncio
import aiohttp
import aiofiles
import requests
from bs4 import BeautifulSoup


def get_catalog():
    """
    找到目标书目录 ，得到章节网址 (同步操作)
    --------------------------------------------------
    :return: chapter_url_list, 包含所有章节网址的列表
    """
    chapter_url_list = []

    resp = requests.get(url, headers=headers)
    if resp.status_code == 200:
        soup = BeautifulSoup(resp.text, "html.parser")
        chapter_path_list = soup.find_all("a")
        for chapter_path in chapter_path_list:
            chapter_href = chapter_path.get("href")
            if chapter_href.startswith("YOUR_BOOK_PATH_PREFIX"):
                chapter_url = chapter_url_head + chapter_href.split("/")[-1]
                chapter_url_list.append(chapter_url)
        print("catalog fetch success!")
    else:
        print("catalog fetch failed:", resp.status_code)

    return chapter_url_list[1:]


async def aiodownload(chapter_url, session):
    """
        进入每个章节，提取下载内容 （异步操作）
    --------------------------------------------------
    :param chapter_url: url for 1 chapter to be downloaded
    :param session: a reusable session
    :return: print execute status of current chapter
    """
    async with session.get(chapter_url, headers=headers) as chapter_resp:
        if chapter_resp.ok:
            chapter_soup = BeautifulSoup(await chapter_resp.text(), "html.parser")
            title_element = chapter_soup.find_all("h1", attrs={"class": "wap_none"})
            text_element = chapter_soup.find_all("div", attrs={"id": "chaptercontent"})
            title = title_element[0].text
            text = text_element
            text_br = fetch_content.findall(str(text))
            text_ok = str(text_br[0]).replace("<br/>", "\n").replace("\u3000", " ")

            # aiofiles, 协程处理文件
            async with aiofiles.open(f"P66_P67_Get_Full_Novel/{title.replace(" ", "_")}.txt", "w", encoding="utf-8") as f:
                await f.write((title + "\n" + "\n" + text_ok))

            global ok_count
            ok_count += 1
            print(f"{ok_count} chapters have been downloaded successfully!")
        else:
            print("a chapter fetch failed:", chapter_resp.status_code)


async def get_full_novel(chapter_url_list):
    """
    创建多个异步协程任务, 集中调度, 完成全书下载
    --------------------------------------------------
    :param chapter_url_list: url for all chapters in current batch to be downloaded
    :return: None
    """
    # 尽量防止IP封锁
    connector = aiohttp.TCPConnector(limit=16, ttl_dns_cache=300, ssl=False)
    timeout = aiohttp.ClientTimeout(total=30)
    # 创建可复用Session
    async with aiohttp.ClientSession(timeout=timeout, connector=connector) as session:
        # 创建多个异步协程任务
        task_list = [aiodownload(chapter_url, session) for chapter_url in chapter_url_list]
        # 允许异步任务挂起
        await asyncio.gather(*task_list)


def main():
    # 1. 同步操作 --- 找到目标书目录 ，得到章节网址
    chapter_url_list_rs = get_catalog()


    # 2. 同步操作 --- 进行分批下载, 每批下载250章, 然后休眠10-15s, 防止协程任务过多, 早期任务连接超时, 导致程序中断
    total_chapters = len(chapter_url_list_rs)
    for start in range(0, total_chapters, 250):
        end = min(start + 250, total_chapters)
        batch = chapter_url_list_rs[start:end]
        print(f"=== Chapter {start + 1}~{end} ===")
        # 3. 异步操作 --- 创建多个异步协程任务, 集中调度, 进入每个章节，提取下载内容, 完成全书下载
        asyncio.run(get_full_novel(batch))  # 跑完一批
        print(f"=================================")
        # 除了最后一批, 其他批同步休眠10-15s
        if end < total_chapters:
            time.sleep(random.uniform(10, 15))


if __name__ == '__main__':
    # basic info
    url = "YOUR_BOOK_INDEX_URL"
    chapter_url_head = "YOUR_CHAPTER_BASE_URL"
    headers = {
        "user-agent": "YOUR_USER_AGENT",
        "connection": "close",
    }
    fetch_content = re.compile('.*?id="chaptercontent">(?P<text_raw>.*?)请收藏本站')
    ok_count = 0

    # let's roll
    main()
    print("process success!")
