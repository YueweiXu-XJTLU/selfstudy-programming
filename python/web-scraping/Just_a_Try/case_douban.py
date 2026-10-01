from bs4 import BeautifulSoup
import requests


headers = {"User-Agent": "YOUR_USER_AGENT"}
URL = "YOUR_API_URL"
count = 0

while count < 250:

    response = requests.get(URL, headers=headers)

    if response.ok:
        soup = BeautifulSoup(response.text, "html.parser")

        all_movie_info = soup.ol
        one_movie_infos = all_movie_info.find_all("li")
        for one_movie_info in one_movie_infos:
            final_title = ''
            titles = one_movie_info.find_all("span", attrs={"class": "title"})
            for title in titles:
                final_title += title.string
            count += 1
            print(count, final_title)
            URL = f"YOUR_PAGE_URL?page={count}"

        response.close()

    else:
        print("request failed: " + str(response.status_code))
