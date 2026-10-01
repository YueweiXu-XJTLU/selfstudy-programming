import requests
import re
import csv

# 写入csv
f = open("P23_P24_Re_Douban_Top_250.csv", mode='w', encoding='utf-8', newline='') # `newline=None`时, python会自动在每次写入数据后换行, 导致一行行写入数据时每两行数据间会多出一个空行, 用`newline=None`告诉python不要加'\n'
csv_writer = csv.writer(f)

# 爬取信息
url = "YOUR_TARGET_URL"
headers = {
    "User-Agent": "YOUR_USER_AGENT",
    "Connection": "close"
}
params = {
    "start": "0",
    "filter": ""
}

end = 0
while end < 250:

    resp = requests.get(url, headers=headers, params=params)

    if resp.ok:

        # 爬名称, 年份, 评分, 评分人数
        # 从几级前开始匹配, 同级不要的可以省略, 不同级的也可以看着省
        re_obj = re.compile((r"<li>.*?<span class=\"title\">(?P<title>.*?)</span>"
                             r".*?<br>.*?(?P<year>\d.*?)&nbsp"
                             r".*?<span class=\"rating_num\" property=\"v:average\">(?P<score>.*?)</span>"
                             r".*?<span>(?P<reviewer>.*?)人.*?</span>"), re.S)
        rs_iter = re_obj.finditer(resp.text)
        for rs in rs_iter:
            dic = rs.groupdict(rs) # 把当前Match对象中所有命名分组的内容，以字典的形式提取出来
            csv_writer.writerow(dic.values()) # 将字典的值写入csv文件
            print(dic)

        end += 25
        params["start"] = str(end)

    else:
        print("failed: ", resp.status_code)
        break

f.close()
