# 多任务异步协程标准写法
import asyncio

async def fun(i):
    print(i, "- 1")

async def main():
    task_list = [
        fun(1),
        fun(2),
        fun(3),
    ]
    await asyncio.gather(*task_list) # await放在协程对象(用*将列表解包)之前

if __name__ == '__main__':
    asyncio.run(main())
