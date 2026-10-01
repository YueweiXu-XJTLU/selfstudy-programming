import requests
import re
import csv


url = "YOUR_TARGET_URL"
headers = {
    "user-agent": "YOUR_USER_AGENT",
    "connection": "close"
}
block_name = input("选择要爬取的板块：") # 选择要爬取的板块: 2025新片精品 / 2025必看热片 / 迅雷电影资源 / 经典大片 / 华语电视剧 / 日韩电视剧 / 欧美电视剧 / 综艺&动漫
sub_infos = []
sub_urls = []
f = open("P25_P27_Re_DianYingTianTang.csv", "w", encoding="utf-8", newline='')
csv_writer = csv.writer(f)

csv_writer.writerow([block_name])

# 1.定位到2025必看热片
resp = requests.get(url, headers=headers)
resp.encoding = "gb2312"
if resp.ok:

    obj = re.compile(rf"{block_name}.*?<ul>(?P<sub_infos>.*?)</ul>", re.S)

    rs_iter = obj.finditer(resp.text)
    for rs in rs_iter:
        sub_infos = rs.group("sub_infos").strip().split("\n")

        # print(sub_infos)
        print("step1: success")
        print("====================")

else:
    print("failed: ", resp.status_code)

# 2. 提取子页面的链接
if sub_infos: # if sub_infos is not empty:

    sub_obj = re.compile(r"<li><a href=\'(?P<sub_path>.*?)\' title=", re.S)
    for sub_info in sub_infos:
        if str(sub_info).startswith("<li><a href=\'"):
            path = sub_obj.search(sub_info)
            sub_url = url + path.group('sub_path')
            sub_urls.append(sub_url)

    # print(sub_urls)
    print("step2: success")
    print("====================")

# 3. 进入子页面, 爬取电影名称及下载磁力链接
for sub_url in sub_urls:
    url = sub_url
    resp = requests.get(url, headers=headers)
    resp.encoding = "gb2312"  # 强制按 gb2312编码解析页面: 电影天堂使用gb2312编码，requests默认resp.text是按utf-8解码的，内容就会乱码，导致正则根本找不到目标
    if resp.ok:

        obj = re.compile(r'''<title>.*?《(?P<title>.*?)》.*?</title>.*?'''
                         r'''【下载地址】.*?<tr>.*?<a href="(?P<magnet>.*?)&tr.*?</tr>''', re.S)

        rs_iter = obj.finditer(resp.text)
        for rs in rs_iter:
            title = rs.group('title').strip()
            magnet = rs.group('magnet').strip()
            # print(rs.group('title'))
            # print(rs.group('magnet'))
            csv_writer.writerow([title, magnet])

    else:
        print("failed: ", resp.status_code)

f.close()
print("step3: success")
print("====================")

print("process: success")
