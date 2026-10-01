from bs4 import BeautifulSoup
import requests

headers = {"User-Agent": "YOUR_USER_AGENT"}
response = requests.get("YOUR_TARGET_URL", headers=headers)
if response.ok:

    # create an instance, use "html.parser" to parse html text
    soup = BeautifulSoup(response.text, "html.parser")

    # find 1st label and elements belong to it
    # print(soup.p)
    # print(soup.img)

    # find all desired labels, return an iterable object
    all_prices = soup.find_all("p", attrs={"class": "price_color"})
    for price in all_prices:
        # print(price)
        print(price.string) # only get text, without labels

    print("==========")

    all_h3 = soup.find_all("h3")
    for h3 in all_h3:
        titles = h3.find_all("a")
        for title in titles:
            print(title.string)

    response.close()

else:
    print("request failed")
