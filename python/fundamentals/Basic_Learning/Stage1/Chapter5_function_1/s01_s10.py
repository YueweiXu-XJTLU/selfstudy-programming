# Function
# None
def thermometer(temperature):
    """
    This is a standard comment for a function

    thermometer(temperature) can verdict if you are in fever according to your input temperature
    :param temperature: your input temperature
    :return: None
    """
    if temperature > 38:
        print("Fever")
    else:
        print("Normal")
    return None # None can be omitted

if __name__ == '__main__':
    thermometer(36.5)

    return_none = thermometer(40)
    print(return_none) # Special return value: None
    print(type(return_none)) # Type of None: <class 'NoneType'>
    if not None: # in if condition, None == False
        print("not None")



print("=====")



# Local & Global Variables
num = 1 # This is a global variable, can be used directly in __main__ & every functions

def a():
    num = 2 # global variable can be directly used
    print(num)
    return

def b():
    global num # but if we want to change value of global variables, we need to manually state
    num = 3
    print(num)
    return

a() # 2
print(num) # 1
b() # 3
print(num) # 3

# if a function is defined inside a class, it is called a method