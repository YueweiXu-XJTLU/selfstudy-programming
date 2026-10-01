def print_file_info(file_path):
    file = None # if no this line, no stuff to verdict whether to close file
    try:
        file = open(file_path, "r")
        print(file.read())
    except Exception as e:
        print(e)
    finally:
        if file:
            file.close()

def append_to_file(file_path, data):
    file = open(file_path, "a")
    file.write(data)
    file.write("\n")
    file.close()

if __name__ == '__main__':
    print_file_info("test.txt")
    append_to_file("test.txt", "data1")