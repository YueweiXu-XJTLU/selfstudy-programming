# Coroutine 协程
# 以下情况针对单线程:

# 一般情况下, 当程序处于IO操作时, 线程会处于阻塞状态, CPU不处理该线程的任务, 转而处理其他任务
# 如: time.sleep(); input(); requests.get(); ...

# 协程: 当程序阻塞后, 可以指定CPU调度该线程处理指定的任务
# 体现为: 多任务一起执行 --- 多任务异步操作/多任务异步协程 (asynchronous multitasking with coroutines)

# ----------------------------------------------------------------------------------------------------

import asyncio
import time


async def fun_1_sync(): # 加上async后, 该函数成为异步协程函数
    print("hello world 1_1")
    time.sleep(4) # 但是这里的time.sleep()是同步操作!!!, 并不会异步执行
    print("hello world 1_2")

async def fun_2_sync():
    print("hello world 2_1")
    time.sleep(2)
    print("hello world 2_2")

async def fun_3_sync():
    print("hello world 3_1")
    time.sleep(0.5)
    print("hello world 3_2")

async def fun_1_async(): # 加上async后, 该函数成为异步协程函数
    print("hello world 1_1")
    await asyncio.sleep(4) # asyncio.sleep()才是异步协程操作!!!, 在异步协程对象前使用await, 将该对象挂起
    print("hello world 1_2")

async def fun_2_async():
    print("hello world 2_1")
    await asyncio.sleep(2)
    print("hello world 2_2")

async def fun_3_async():
    print("hello world 3_1")
    await asyncio.sleep(0.5)
    print("hello world 3_2")

async def run_sync(): # 同时启动多个同步函数
    await asyncio.gather(
        fun_1_sync(),
        fun_2_sync(),
        fun_3_sync(),
    )

async def run_async(): # 同时启动多个异步协程函数
    await asyncio.gather(
        fun_1_async(),
        fun_2_async(),
        fun_3_async(),
    )

if __name__ == '__main__':
    # fun_1 = fun_1() # 异步协程函数返回异步协程对象
    # asyncio.run(fun_1) # 这样可以直接运行异步协程函数

    # 同时启动多个同步函数
    sync_time_start = time.time()
    asyncio.run(run_sync())
    sync_time_end = time.time()
    print("synchronous time cost [theoretical limit: sum(4, 2, 0.5) = 6.5s]:", sync_time_end - sync_time_start)
    print('-'*100)

    # 同时启动多个异步协程函数
    async_time_start = time.time()
    asyncio.run(run_async())
    async_time_end = time.time()
    print("asynchronous time cost [theoretical limit: max(4, 2, 0.5) = 4s]:", async_time_end - async_time_start)
    print('-'*100)
