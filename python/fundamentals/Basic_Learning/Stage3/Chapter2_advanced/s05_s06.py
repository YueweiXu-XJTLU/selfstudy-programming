def print_numbers(start, end):
    for i in range(start, end):
        print(i)

# multiple threads

import threading

thread_obj_1 = threading.Thread(target=print_numbers, args=(10000, 19999))
thread_obj_2 = threading.Thread(target=print_numbers, kwargs={'start': 20000, 'end': 29999})
thread_obj_3 = threading.Thread(target=print_numbers(30000, 39999))

thread_obj_1.start()
thread_obj_2.start()
thread_obj_3.start()