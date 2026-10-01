# closure
# encapsulate an inner function inside a outer function
# let inner function get access to variables in outer function, improve data security
from _pyrepl.commands import end


def outer(outer_str: str):

    def inner(inner_str: str):
        return f"{outer_str} says: {inner_str}" # outer_str here is an outer variable

    return inner

if __name__ == "__main__":
    speaker = outer("san.zhang") # type(speaker) == function_inner, the variable "outer_str" is temporarily stored in speaker and not modifiable to words

    words_1 = speaker("Hello guys!") # type(words_1) == str
    print(words_1)

    words_2 = speaker("Nice to meet you!")
    print(words_2)

    print("==========")



# nonlocal
# a keyword to make outer function variables modifiable
def atm(balance: float):
    print(f"current balance: {balance}")

    def manipulation(money: float, deposit: bool):
        nonlocal balance
        if deposit:
            balance += money
        if not deposit:
            balance -= money
        print(f"current balance: {balance}")

    return manipulation

if __name__ == "__main__":
    account_1 = atm(balance=100)
    operation_1 = account_1(100, deposit=True)
    operation_2 = account_1(10, deposit=False)
    print("==========")



# decorator
# a kind of closure, add new functions to function, without interfering its previous functions
def outer(fun):
    def inner():
        start()
        fun()
        end()

    def start():
        print("start")

    def end():
        print("end")

    return inner

@outer # syntactic sugar: automatically invoke closure code block
def sleep():
    import random
    import time
    print("sleeping...")
    time.sleep(random.randint(1, 3))

# fun = outer(sleep)
# fun()
sleep() # with syntactic sugar, we can directly invoke the previous function