# String

# 3 methods for str assignment
name1 = ' "me" '
name2 = " 'me' "
name3 = """
\"me
me
me\"
"""
print(type(name1), name1)
print(type(name2), name2)
print(type(name3), name3)

# concat
ef = "EF"
num = 123
print("AB" + "CD" + ef + str(num))

# formatting str 1: placeholder 占位符
# %s : casting into str
# %d : casting into decimal int
# %f : casting into float
print("ABCD%s%f" %(ef, num))

# decimal precision control
# [m][.n] : m is width, n is width of fraction
# m must > n & the width of the object itself
# round, not just cut !!!
num = 123.456
print("these are number of controlled decimal precision: %6.3f /// %20f /// %.2f ///%4d" % (num, num, num, num))
# %20f mean the min width of the whole float (include integer & .) is 20, by default, float have 6 digits for fraction, so the number before f must >7 to make it work

# formatting str 2: fast formatting: do not cast type, do not control decimal precision
print(f"ABCD{ef}{num}")

# formatting str 3: formatting expressions (do not store data using variable to save resource)
# expression: a state with a specific result_1
print("1 + 1 = %d" %(1 + 1))
print(f"type of str in python is {type(str)}")