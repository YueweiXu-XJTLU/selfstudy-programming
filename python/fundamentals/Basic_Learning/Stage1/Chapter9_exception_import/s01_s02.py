# exception handling
try:
    file = open("primarily_not_exist", "r")
except: # catch all exceptions, same as `exception Exception as e`
    print("exception! file is not exist, create it first!")
    file = open("primarily_not_exist", "w")
else:
    print("success! file is opened!")
finally:
    file.close()
    print("finally! file is closed")

print("----------")

try:
    print(name)
    print(1 / 0)
except (NameError, ZeroDivisionError) as e:
    print(e, type(e))