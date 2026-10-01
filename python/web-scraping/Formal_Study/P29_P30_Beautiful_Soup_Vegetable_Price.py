from bs4 import BeautifulSoup
import requests
import csv


f = open("P29_P30_Beautiful_Soup_Vegetable_Price.csv", mode='w', newline='')
csv_writer = csv.writer(f)
url = "YOUR_TARGET_URL"
headers = {
    "user-agent": "YOUR_USER_AGENT",
    "Connection": "close"
}
resp = requests.get(url=url, headers=headers)
if resp.ok:

    # print(login_resp.text)

    # 使用BeautifulSoup:

    # 1. 创建BeautifulSoup对象:
    soup = BeautifulSoup(resp.text, "html.parser") # 指定html解析器

    # 2. 适用对象查找数据: BeautifulSoup解析逻辑: 通过标签的特征（属性&值）定位内容: find()抓一个find_all()抓所有
    # tables = soup.find_all("div", class_="box_out_form box_out_form2") # class后加下划线，防止与python的class关键字冲突
    # OR
    tables = soup.find_all("div", attrs={"class": "box_out_form box_out_form2"})
    # print(tables)

    for table in tables:
        rows = table.find_all("tr")
        # print(rows)

        for row in rows:
            tds = row.find_all("td")
            # print(tds)

            if len(tds) > 0:
                # 去除label包围的内容
                data = tds[0].text.strip()
                item = tds[1].text.strip()
                price = tds[2].text.strip()
                # print(data, item, price)
                csv_writer.writerow([data, item, price])

    f.close()
    print("success")

else:
    print("failed: ", resp.status_code)