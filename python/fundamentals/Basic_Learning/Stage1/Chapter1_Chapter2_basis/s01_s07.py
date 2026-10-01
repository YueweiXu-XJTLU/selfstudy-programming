# data types
print(1) # int
print(12.34) # float_var
print("aaa", "bbb") # str

# commnts
"""
multiple
lines
comments
"""

# variable types
var = 10
print(var)

var_type = type(var) # type of data in variable: variable DO NOT have type, its data have
print(var_type)

# type casting
new_var = str(var)
print(type(new_var))

float_var = 12.99999
print(type(int(float_var)), int(float_var))

# calculation operators
a = 11
b = 5
print(a // b) # 取整
print(a % b) # 取余
print(a ** b) # 乘方

a //= b
print(a)

#let print() not change a new line
print("line_1_1", end= " ")
print("line_1_2", end= "")