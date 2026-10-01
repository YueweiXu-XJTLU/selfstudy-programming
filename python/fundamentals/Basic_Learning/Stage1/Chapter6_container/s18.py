# common manipulations
my_list = [1, 2, 3]
my_tuple = (1, 2, 3)
my_str = "123"
my_set = {1, 2, 3}
my_dict = {"A": 1, "B": 2, "C": 0}

# len()
print(len(my_list), len(my_tuple), len(my_str), len(my_set), len(my_dict))

# max()
print(max(my_list), max(my_tuple), max(my_str), max(my_set), max(my_dict)) # for dict, max()/min() compare and return keys

# cast
print(list(my_list), list(my_tuple), list(my_str), list(my_set), list(my_dict)) # for dict, list() only return keys

# sorted()
print(sorted(my_list, reverse=True), sorted(my_tuple, reverse=True), sorted(my_str, reverse=True), sorted(my_set, reverse=True), sorted(my_dict, reverse=True)) # all return list(), dict return list of keys