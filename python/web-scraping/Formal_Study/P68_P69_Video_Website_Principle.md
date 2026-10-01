# P68_P69_Video_Website_Principle

## 视频网站工作原理
1. 用户上传视频
2. 视频转码 --> 4K & 2K & 1080P & ...
3. 视频切片 --> 方便用户拖动进度条
4. 用一个**m3u8文件**记录: 视频切片播放顺序 + 视频切片存放路径 + 视频其它元信息

## m3u8解读
```m3u8
#EXTM3U
#EXT-X-VERSION:3 ----------> 版本
#EXT-X-PLAYLIST-TYPE:VOD
#EXT-X-MEDIA-SEQUENCE:0
#EXT-X-TARGETDURATION:9 ----------> 每个ts的最长时间(s)
# EXT-X-KEY:METHOD=AES-128,URI="key.key" ----------> 切片文件的加密方式及加密的密钥地址
#EXT-X-DISCONTINUITY
#EXTINF:6.381, ----------> 该ts的时间(s)
e4734e67d70000000.ts ----------> 该ts的路径(含index --> 播放顺序)
#EXTINF:4.171,
e4734e67d70000001.ts
#EXTINF:4.171,
e4734e67d70000002.ts
#EXTINF:4.171,
e4734e67d70000003.ts
#EXTINF:3.712,
e4734e67d70000004.ts
#EXTINF:4.171,
e4734e67d70000005.ts
#EXTINF:3.629,
e4734e67d70000006.ts
```

## 爬取视频流程
1. 找到并下载m3u8文件
2. 通过m3u8找到并下载所有ts
3. 按m3u8文件中的顺序合并ts文件, 得到原始视频文件
