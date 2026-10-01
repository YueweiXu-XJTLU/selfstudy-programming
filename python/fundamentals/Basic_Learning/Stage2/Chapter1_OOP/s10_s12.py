# type annotation
# variables
int_var_1: int = 10
#OR
int_var_2 = 10 # type: int



# container
list_container_1: list = [1, 2, 4]
#OR
list_container_2 = [1, 2, 4] # type: list[int]

tuple_container_1: tuple[int, int, int] = (1, 2, 3) # tuple must state data type for every element
tuple_container_2: tuple[int, float, bool] = (1, 2.3, True)

dict_container: dict[str, int] = {"key1": 1, "key2": 2, "key3": 3}



# class
class Phone:
    pass

phone_1: Phone = Phone()
#OR
phone_2 = Phone() # type: Phone



# function
def fun_1(data: list[int]) -> int:
    return 1

fun_return_1: int = fun_1(list_container_1) # `ctrl + p` to show annotations
#OR
fun_return_2 = fun_1(list_container_1) # type: int



# union
from typing import Union
mixed_dict: dict[str, Union[int, float]] = {"key1": 1, "key2": 2.3, "key3": 3}

def fun_2(data: Union[list[int], tuple[int]]) -> Union[int, float]:
    return 1

fun_return_3 = fun_2(list_container_1) # type: Union[int, float]