# return multiple values
def return_test():
    return "aaa", 111

if __name__ == '__main__':
    returned_value = return_test()
    print(returned_value, type(returned_value))

    returned_value_1, returned_value_2 = return_test()
    print(returned_value_1, type(returned_value_1))
    print(returned_value_2, type(returned_value_2))