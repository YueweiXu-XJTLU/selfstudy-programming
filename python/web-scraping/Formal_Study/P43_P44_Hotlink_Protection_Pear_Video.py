import requests


url = "YOUR_STATUS_URL"
headers = {
    "user-agent": "YOUR_USER_AGENT",
    # 防盗链：溯源本网页的上级网页，若有异常，拒绝访问
    # 破解方法：header中加referer（上级网页）的url，可在ERequest Headers中找到
    "referer": "YOUR_REFERER_URL",
    "connection": "close",
}
params = {
    "contId": "YOUR_VIDEO_ID" ,
    "mrd": "YOUR_REQUEST_NONCE",
}
resp = requests.get(url, headers=headers, params=params)
resp.encoding = "utf-8"
if resp.ok:
    raw_video_url = resp.json()["videoInfo"]["videos"]["srcUrl"] # 到这里已经成功破解防盗链，下面是以一些其它处理
    replace_from = raw_video_url.split("/")[-1].split("-")[0]
    replace_to = "cont-" + params["contId"]
    video_url = raw_video_url.replace(replace_from, replace_to)

    # 下载视频
    video_resp = requests.get(video_url)
    if video_resp.ok:
        with open("P43_P44_Hotlink_Protection_Pear_Video.mp4", "wb") as f:
            f.write(video_resp.content)
    else:
        print("video fetch failed: ", resp.status_code)

else:
    print("web fetch failed: ", resp.status_code)

print("success")
