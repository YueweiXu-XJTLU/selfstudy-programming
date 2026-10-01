import os
import re
import aiohttp
import asyncio
import aiofiles
import requests
import subprocess


# 1. 找到并下载m3u8文件
def get_m3u8():
    url = "YOUR_PLAYLIST_URL"
    resp = requests.get(url=url, headers=headers)
    resp.encoding = "utf-8"
    if resp.status_code == 200:
        with open("P70_P73_Download_Video_Simple.m3u8", "wb") as f:
            f.write(resp.content)
        print("P70_P73_Download_Video_Simple.m3u8: download success!")
    else:
        print("failed:", resp.status_code)


# 2. 通过m3u8找到并下载所有ts
async def download_all_ts():
    ts_url_list = []
    ts_url_head = "YOUR_SEGMENT_BASE_URL"
    with open("P70_P73_Download_Video_Simple.m3u8", "r") as f:
        for line in f.readlines():
            if line.strip().startswith("#"):
                continue
            this_ts_url = ts_url_head + line.strip()
            ts_url_list.append(this_ts_url)

    connector = aiohttp.TCPConnector(limit=16, ttl_dns_cache=300, ssl=False)
    timeout = aiohttp.ClientTimeout(total=30)
    async with aiohttp.ClientSession(timeout=timeout, connector=connector) as session:
        task_list = [aiodownload(ts_url, session) for ts_url in ts_url_list]
        await asyncio.gather(*task_list)
    print("all ts: download success!")


async def aiodownload(ts_url, session):
    title = ts_url.split('/')[-1]
    async with session.get(ts_url, headers=headers) as ts_resp:
        if ts_resp.status == 200:
            async with aiofiles.open(f"P70_P73_Download_Video_Simple/{title}.ts", "wb") as f:
                await f.write(await ts_resp.content.read())
                print(f"{title}: download success!")
        else:
            print(f"{title} fetch failed:", ts_resp.status_code)


# 3. 按m3u8文件中的顺序合并ts文件, 得到原始视频文件
# 合并ts文件
def merge_ts():
    with open("P70_P73_Download_Video_Simple_Merged_ts.ts", "wb") as merged_ts:
        for f in sorted(os.listdir("P70_P73_Download_Video_Simple"), key=extract_num):
            with open(os.path.join("P70_P73_Download_Video_Simple", f), "rb") as ts:
                    merged_ts.write(ts.read())
    print("P70_P73_Download_Video_Simple_Merged_ts.ts: merge success!")


# 提取文件名中最长的数字串作为排序依据
def extract_num(filename):
    nums = re.findall(r"\d+", filename)
    return int(nums[-1]) if nums else -1


# 用ffmpeg转换ts为mp4
def convert_to_mp4():
    # 全都用绝对路径, 不然会报错
    ffmpeg_path = "YOUR_FFMPEG_PATH"
    ts_file = "YOUR_TS_FILE"
    output_file = "YOUR_OUTPUT_FILE"
    cmd = [
        ffmpeg_path,
        "-y",                # 覆盖已有文件
        "-i", ts_file,     # 输入 ts
        "-c", "copy",        # 不重新编码，直接拷贝
        output_file
    ]
    subprocess.run(cmd, check=True)
    print("P70_P73_Download_Video_Simple_Final_Video.mp4: convert success!")


def main():
    # 1. 找到并下载m3u8文件
    get_m3u8()
    # 2. 通过m3u8找到并下载所有ts
    asyncio.run(download_all_ts())
    # 3. 按m3u8文件中的顺序合并ts文件, 得到原始视频文件
    merge_ts()
    convert_to_mp4()


if __name__ == "__main__":
    headers = {
        "user-agent": "YOUR_USER_AGENT",
        "connection": "close"
    }
    main()
