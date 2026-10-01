import os
import re
import shutil
import aiohttp
import asyncio
import aiofiles
import requests
import subprocess
from Crypto.Cipher import AES


# 1. 找到并下载m3u8文件
def get_m3u8():
    resp = requests.get(url=m3_u8_url, headers=headers)
    resp.encoding = "utf-8"
    if resp.status_code == 200:
        with open(m3_u8_file, "wb") as f:
            f.write(resp.content)
        print(f"{m3_u8_file}: download success!")
    else:
        print("failed:", resp.status_code)


# 2. 通过m3u8找到并下载所有ts
async def download_all_ts():
    ts_url_list = []
    with open(m3_u8_file, "r") as f:
        for line in f.readlines():
            if line.strip().startswith("#"):
                continue
            this_ts_url = ts_url_head + line.strip()
            ts_url_list.append(this_ts_url)

    connector = aiohttp.TCPConnector(limit=concurrency_limit, ttl_dns_cache=300, ssl=False)
    timeout = aiohttp.ClientTimeout(total=timeout_limit)
    async with aiohttp.ClientSession(timeout=timeout, connector=connector) as session:
        task_list = [aio_download(ts_url, session) for ts_url in ts_url_list]
        await asyncio.gather(*task_list)
    print("all ts: download success!")


async def aio_download(ts_url, session):
    title = ts_url.split('/')[-1].split('?')[0]
    async with session.get(ts_url, headers=headers) as ts_resp:
        if ts_resp.status == 200:
            async with aiofiles.open(f"{ts_dir}/{title}", "wb") as f:
                await f.write(await ts_resp.content.read())
                print(f"{title}: download success!")
        else:
            print(f"{title} fetch failed:", ts_resp.status_code)


def get_key():
    # 解析存放解密密钥URI (统一资源标识符，Uniform Resource Identifier)的地址 & IV
    key_re = re.compile(r'.*?KEY.*?')
    key_url_re = re.compile(r'URI="(?P<KEY_URI>.*?)"')
    key_iv_re = re.compile(r'IV=0x(?P<KEY_IV>[0-9a-fA-F]{32})') # IV要求去除开头 "0x"
    with (open(m3_u8_file, "r") as f):
        for line in f.readlines():
            contain_key = key_re.findall(line)
            if len(contain_key) == 0:
                continue
            key_url = key_url_re.search(line).group("KEY_URI").strip()
            iv = bytes.fromhex(key_iv_re.search(line).group("KEY_IV").strip()) # IV要求去除开头 "0x", 将后32位字符转为16位字节后传入AES

    # 下载URI
    key_resp = requests.get(url=key_url, headers=headers)
    if key_resp.status_code == 200:
        key = key_resp.content # 取到字节内容 (如果需要肉眼看具体内容的话用16进制解码(key = key_resp.content.hex())
        return key, iv
    else:
        print("failed:", key_resp.status_code)
        return None


# 3. 解密
# 得到密钥
async def decode(key, iv):
    task_list = []
    async with aiofiles.open(m3_u8_file, "r", encoding="utf-8") as f:
        async for line in f:
            if line.strip().startswith("#"):
                continue
            task = aio_decode_ts(line.strip().split("/")[-1].strip().split("?")[0], key, iv)
            task_list.append(task)
        await asyncio.gather(*task_list)


# 逐个ts用密钥解密
async def aio_decode_ts(file_name, key, iv):
    # 加密模式见m3u8的key行METHOD, AES-128为AES-128-CBC
    aes = AES.new(key=key, iv=iv, mode=AES.MODE_CBC)
    async with aiofiles.open(f"{ts_dir}/{file_name}", "rb") as read_from:
        async with aiofiles.open(f"{ts_dir}/temp_{file_name}", "wb") as write_to:
            bs = await read_from.read()
            await write_to.write(aes.decrypt(bs))
    # 删除原文件
    os.remove(f"{ts_dir}/{file_name}")
    # 重命名临时文件为原文件
    shutil.move(f"{ts_dir}/temp_{file_name}", f"{ts_dir}/{file_name}") # shutil == shell utils
    print(f"{file_name}: decode success!")


# 4. 按m3u8文件中的顺序合并ts文件, 得到原始视频文件
# 合并ts文件
def merge_ts():
    with open(merged_ts_file, "wb") as merged_ts:
        for f in sorted(os.listdir(ts_dir), key=extract_num):
            with open(os.path.join(ts_dir, f), "rb") as ts:
                merged_ts.write(ts.read())
    print(f"{merged_ts_file}: merge success!")


# 提取文件名中最长的数字串作为排序依据
def extract_num(filename):
    nums = re.findall(r"\d+", filename)
    return int(nums[-1]) if nums else -1


# 用ffmpeg转换ts为mp4
def convert_to_mp4():
    cmd = [
        ffmpeg_path,
        "-y",                # 覆盖已有文件
        "-i", ts_file_full,     # 输入 ts
        "-c", "copy",        # 不重新编码，直接拷贝
        mp4_file
    ]
    subprocess.run(cmd, check=True)
    print(f"{mp4_file}: convert success!")


def main():
    # 1. 找到并下载m3u8文件
    get_m3u8()
    # 2. 通过m3u8找到并下载所有ts
    asyncio.run(download_all_ts())
    # 3. 解密
    key, iv = get_key()
    asyncio.run(decode(key, iv))
    # 4. 按m3u8文件中的顺序合并ts文件, 得到原始视频文件
    merge_ts()
    convert_to_mp4()
    # 5. 下载后清除多余临时资源
    os.remove(f"{m3_u8_file}")
    os.remove(f"{merged_ts_file}")
    shutil.rmtree(ts_dir)
    os.makedirs(ts_dir)


if __name__ == "__main__":
    headers = {
        "user-agent": "YOUR_USER_AGENT",
        "connection": "close"
    }

    ffmpeg_path = "YOUR_FFMPEG_PATH"

    m3_u8_url = ""
    ts_url_head = ""

    ts_dir = "P74_P84_Perfect_Video_Download_With_Decrypt"
    m3_u8_file = "P74_P84_Perfect_Video_Download_With_Decrypt.m3u8"
    merged_ts_file = "P74_P84_Perfect_Video_Download_With_Decrypt.ts"

    ts_file_full = "YOUR_TS_FILE"
    mp4_file = "YOUR_OUTPUT_FILE"

    concurrency_limit = 128
    timeout_limit = 300 # second

    main()
