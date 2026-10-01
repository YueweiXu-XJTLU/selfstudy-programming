import requests
from lxml import etree
from concurrent.futures import ThreadPoolExecutor


def fetch_single_page(page_number, file):
    info_list = [] # [time, name, place, price]
    url = f"YOUR_PAGE_URL/{page_number}"
    headers = {
        "user-agent": "YOUR_USER_AGENT",
        "referer": "YOUR_REFERER_URL",
        "connection": "close"
    }
    resp = requests.get(url, headers=headers)
    if resp.ok:
        tree = etree.HTML(resp.text)
        content_list = tree.xpath('//div[@class="quotation-content"]/div[@class="quotation-content-list"]/ul/li[@class="market-list-item"]/a/span/text()')
        for i in range(len(content_list)):
            if content_list[i].startswith("\n"):
                continue
            info_list.append(content_list[i])
        for i in range(len(info_list)):
            if i % 4 == 0:
                one_line = ""
            one_line = one_line + ',' + info_list[i]
            if i % 4 == 3:
                one_line = one_line + "\n"
                with open(file, mode='a', encoding='utf-8', newline='') as f:
                    f.write(one_line[1:])
    else:
        print("failed:", resp.status_code)
    print("page", page_number, "success!")

if __name__ == '__main__':
    with ThreadPoolExecutor() as tp:
        for i in range(1, 6):
            tp.submit(fetch_single_page, i, "P58_P59_Thread_Pool_Vegetable_Price.csv")

    print("all success!")
