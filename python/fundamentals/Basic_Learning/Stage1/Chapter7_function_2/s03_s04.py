# anonymous function - function as parameter
def add(a, b):
    return a + b

def sub(a, b):
    return a - b

def calculator(operation, a, b):
    return operation(a, b)

if __name__ == '__main__':
    print(calculator(add, 1, 2))
    print(calculator(sub, 3, 1))



# anonymous function - lambda
# `lambda argument_list: one_line_statement, parameter_list`
# define functions that will be used only once
if __name__ == '__main__':
    print(calculator(lambda a, b: a * b, 4, 5))