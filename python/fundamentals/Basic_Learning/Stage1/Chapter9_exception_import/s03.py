# pass of exceptions
def fun_1():
    print("start fun_1")
    num = 1 / 0
    print("end fun_1")

def fun_2():
    print("start fun_2")
    fun_1()
    print("end fun_2")

def main():
    print("start main")
    fun_2()
    print("end main")

if __name__ == "__main__":
    try:
        main()
    except Exception as e:
        print(e) # if e is catch to print here, no "end ..." will be further executed