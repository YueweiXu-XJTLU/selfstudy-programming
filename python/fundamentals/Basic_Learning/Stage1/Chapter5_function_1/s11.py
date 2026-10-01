def query_balance():
    print(f"current balance: {balance}")

def withdraw():
    money = float(input("enter money to withdraw: "))
    global balance
    balance = balance - money
    print(f"current balance: {balance}")

def deposit():
    money = float(input("enter money to deposit: "))
    global balance
    balance = balance + money
    print(f"current balance: {balance}")

def welcome(name):
    while True:
        cmd = input(f"========== \nWelcome to ATM system, {name}! \n 1. query balance \n 2. withdraw \n 3. deposit \n 4. exit \nPlease choose: ")
        if cmd == "1":
            query_balance()
            continue
        elif cmd == "2":
            withdraw()
            continue
        elif cmd == "3":
            deposit()
            continue
        else:
            return

if __name__ == "__main__":
    balance = 10000
    name = input("Enter your name: ")
    welcome(name)