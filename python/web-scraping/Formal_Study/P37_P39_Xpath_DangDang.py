import requests
from lxml import etree
import csv


file = open("P37_P39_Xpath_DangDang.csv", mode='w', encoding='utf-8', newline='')
csv_writer = csv.writer(file)
url = "YOUR_TARGET_URL"
headers = {
    "user-agent": "YOUR_USER_AGENT",
    "connection": "close"
}
resp = requests.get(url=url, headers=headers)
resp.encoding = "gb2312"
if resp.ok:

    tree = etree.HTML(resp.text)
    # 尽量不要直接从检查里复制Xpath!!!
    # 那个是经过渲染的Xpath, 和resp.text()拿到的不一定一样!!!
    # 最好自己写相对路径, 合理偷懒即可
    li_list = tree.xpath('//ul[@class="bang_list clearfix bang_list_mode"]/li')

    for li in li_list:
        title = li.xpath('./div[@class="name"]/a/text()')[0]
        price = li.xpath('./div[@class="price"]/p[1]/span[1]/text()')[0]
        csv_writer.writerow([title, price])

else:
    print("fail:", resp.status_code)

file.close()
print("success")
