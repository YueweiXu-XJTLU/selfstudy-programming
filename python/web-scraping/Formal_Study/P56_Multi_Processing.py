from multiprocessing import Process, Lock


# 多进程:

def fun_1(name):
    for i in range(1000):
        print(name, i)

def fun_2(name):
    for i in range(1000):
        print(name, i)

class MyProcess(Process):
    # 在构造函数中传参
    def __init__(self, name):
        super().__init__()
        self.name = name

    # 该进程在start()后会自动执run()方法
    def run(self):
        fun_2(name=self.name)

if __name__ == '__main__':

    #创建进程
    # 1. 使用Thread创建进程并分配任务, 并使用元组向进程任务传参
    p1 = Process(target=fun_1, args=("fun_1",))
    # 2. 使用自己创建的MyThread类创建进程, 该进程在start()后会自动执run()方法, 并在构造函数中传参
    p2 = MyProcess(name="fun_2")

    # 该进程在start()后会自动执run()方法
    p1.start()
    p2.start()
