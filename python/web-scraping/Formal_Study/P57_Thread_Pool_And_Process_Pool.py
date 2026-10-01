from concurrent.futures import ThreadPoolExecutor, ProcessPoolExecutor


# 线程池/进程池: 使用一些线程/进程开辟线程池/进程池, 直接向其交付任务, 自动调度

def fun(task_id):
    for i in range(1000):
        print(task_id, i)

if __name__ == '__main__':
    # 线程池:
    # 创建线程池, 指定可用线程数
    with ThreadPoolExecutor(max_workers=10) as tp:
        for i in range(50):
            # 提交任务, 并直接传参给任务
            tp.submit(fun, task_id = f"tp_Task_{i}")

    print("All task in tp is done, this line executes after it!")


    # 进程池:
    # 创建进程池, 指定可用进程数
    with ProcessPoolExecutor(max_workers=10) as pp:
        for i in range(50):
            # 提交任务, 并直接传参给任务
            pp.submit(fun, task_id = f"pp_Task_{i}")

    print("All task in pp is done, this line executes after it!")
