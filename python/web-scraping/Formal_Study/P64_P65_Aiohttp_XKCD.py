import aiohttp # aiohttp == async-io-htp, request的异步协程版
import asyncio


url_list = [
    'YOUR_IMAGE_URL_1',
    'YOUR_IMAGE_URL_2',
    'YOUR_IMAGE_URL_3',
]

async def aiodownload(url):
    # async with ... as ... : 用于开启需要等待后才能开启/释放的对象
    # with ... as ... : 用于开启直接就能开启/释放的对象
    # await: 挂起任务, 等确实接收到数据再进行操作
    async with aiohttp.ClientSession() as session: # session request.session()
        async with session.get(url) as resp: # resp = session.get()
            # resp.text() # resp.text
            # resp.json() # resp.json()
            # resp.content.read() # resp.content
            with open(f"P64_P65_Aiohttp_XKCD_{url.split('/')[-1]}", "wb") as f:
                f.write(await resp.content.read()) # await将任务挂起, 等确实接收到数据再写入
    print(url.split('/')[-1], "success")

async def main():
    task_list = []
    for url in url_list:
        task_list.append(aiodownload(url))
    await asyncio.gather(*task_list)

if __name__ == '__main__':
    asyncio.run(main())
    print("success")
