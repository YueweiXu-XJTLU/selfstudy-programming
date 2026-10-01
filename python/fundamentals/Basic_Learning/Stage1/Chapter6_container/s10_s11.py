# sequence (list, tuple, str)
my_list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
new_my_list_1 = my_list[1 : 4] # [start, end)
new_my_list_2 = my_list[ : : 2]
new_my_list_3 = my_list[8 : 1 : -2] # in reverse order
print(new_my_list_1, new_my_list_2, new_my_list_3)