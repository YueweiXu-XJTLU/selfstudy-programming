# data container - list
# define
list_1 = [1, 2.3, "4"]
print(list_1, type(list_1))

empty_list_1 = []
empty_list_2 = list()

nested_list = [list_1, empty_list_1, empty_list_2]
print(nested_list)

# query
print(nested_list[0][-2]) # last element has index -1

print(list_1.index("4"))
# print(list_1.index(4))

# add
list_1.insert(0, "First Element")
list_1.extend([7, 8, 9]) # copyAll
list_1.append([7, 8, 9]) # add one element

# delete
pop_element = list_1.pop(2) # same as: del list_1[2]
list_1.remove(7)
print(list_1)

print(list_1.count("First Element"))

if len(list_1) != 0:
    list_1.clear()
    print(list_1)

# iterate
num_list = [1, 2, 3]

i = 0
while i < len(num_list):
    print(num_list[i], end = "")
    i += 1

print()

for i in num_list: # here i is element
    print(i, end = "")

print()

for i in range(len(num_list)): # here i is index
    print(num_list[i], end = "")