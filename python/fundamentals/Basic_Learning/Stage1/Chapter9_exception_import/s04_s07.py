# module
import time as tm # from time import sleep

print("A")
tm.sleep(3) # sleep(3)
print("B")

# in module:
# if __name__ == '__main__':

# in module:
# __all__ = ['fun_1', 'fun_2']
# add constraints to * when importing



# package
# if a directory has __init__.py, then it is called a package
# then import and use anything inside the package

# in __init__.py:
# __all__ = ['module_1', 'module_2']
# add constraints to * when importing