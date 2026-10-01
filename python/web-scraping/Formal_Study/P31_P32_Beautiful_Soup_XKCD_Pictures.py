import requests
from bs4 import BeautifulSoup
import time


out_dir = "P31_P32_Beautiful_Soup_XKCD_Pictures" # 对于一些内容无实际开发意义的文件夹，建议取消索引构建，避免pycharm占用过多资源：Project > 右键目标文件(夹) > Mark Directory as > Excluded
url = "YOUR_ARCHIVE_URL"
sub_url = "YOUR_SITE_BASE_URL"
headers = {
    "user-agent": "YOUR_USER_AGENT",
    "connection": "close"
}
resp = requests.get(url, headers=headers)
resp.encoding = "utf-8"
if resp.ok:

    # 1. 获取所有待下载图片的url
    img_page_url_list = []
    soup = BeautifulSoup(resp.text, "html.parser")
    img_info_list = soup.find_all("a", attrs={"href": True, "title": True}) # `soup.find(attrs={"id": True})`可以仅判断标签有无，不判断标签值
    for img_info in img_info_list:
        img_path = img_info.get("href") # `soup.get("label")`可以直接拿到label包围的对象
        if int(img_path[1:-1]) > 3120: # 只下一部分，全下太多了
            img_page_url = sub_url + img_path
            img_page_url_list.append(img_page_url)

    # 2. 在每个图片的网址中找到图片
    img_url_list = []
    for img_page_url in img_page_url_list:
        sub_resp = requests.get(img_page_url, headers=headers)
        sub_soup = BeautifulSoup(sub_resp.text, "html.parser")
        img_url = sub_soup.find("img", attrs={"src": True, "title": True})
        img_url_list.append("http:" + img_url.get("src"))

    # 3. 下载图片
    # 图片网页里可能有预览图和原图，注意分辨
    # 下载图片等内容，直接使用resp.content拿到字节内容，写入文件即可
    for img_url in img_url_list:
        sub_sub_resp = requests.get(img_url, headers=headers)
        picture_name = img_url.split("/")[-1]

        with open(f"{out_dir}/{picture_name}", mode="wb") as f: # `wb` = write binary, 二进制写入模式
            f.write(sub_sub_resp.content)
        print(f"{out_dir}/{picture_name}: success")
        time.sleep(1) # 下完一张图片最好等待一会: `import time` & `time.sleep(1)`: 等待一秒

    print("process success")

else:
    print("failed: ", resp.status_code)