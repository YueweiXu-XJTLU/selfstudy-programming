# 进程: 资源单位 (公司业务)
# 线程: 执行单位 (公司员工)
from threading import Thread, Lock


# 多线程:
# 全局锁对象
lock = Lock()

def fun_1(name):
    for i in range(1000):
        # 加锁, 防止两个线程在同一行打印内容
        with lock:
            print(name, i)

def fun_2(name):
    for i in range(1000):
        # 加锁, 防止两个线程在同一行打印内容
        with lock:
            print(name, i)

class MyThread(Thread):
    # 在构造函数中传参
    def __init__(self, name):
        super().__init__()
        self.name = name

    # 该线程在start()后会自动执run()方法
    def run(self):
        fun_2(name=self.name)

if __name__ == '__main__':

    #创建线程
    # 1. 使用Thread创建线程并分配任务, 并使用元组向线程任务传参
    t1 = Thread(target=fun_1, args=("fun_1",))
    # 2. 使用自己创建的MyThread类创建线程, 该线程在start()后会自动执run()方法, 并在构造函数中传参
    t2 = MyThread(name="fun_2")

    # start()只是确定线程为就绪状态, 具体执行时机/顺次由CPU调度
    t1.start()
    t2.start() # 该线程在start()后会自动执run()方法
