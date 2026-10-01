# data container - tuple: NON-MODIFIABLE list
# define
tuple_1 = (1, 2.3, "4")
tuple_2 = (5, )
print(tuple_2, type(tuple_1))
none_tuple_1 = ()
none_tuple_2 = tuple()

# query
print(tuple_1.index(2.3))
print(tuple_1.count("4"))

# iterate
for i in range(len(tuple_1)):
    print(tuple_1[i], end = " ")

print()