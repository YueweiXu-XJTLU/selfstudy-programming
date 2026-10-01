# recursion
import os

# os.listdir(r"YOUR_DIRECTORY") # list all contents
# os.path.isdir(r"YOUR_DIRECTORY") # if is a directory
# os.path.exists(r"YOUR_DIRECTORY") # if the directory exists

def list_all_files_recursively(path):
    """
    list all files recursively
    :param path: path to directory
    :return: all files in directory as a list, if not file or wrong path, return empty list
    """

    all_files = []

    if os.path.exists(path):
        contents_list = os.listdir(path)

        for item in contents_list:
            item_path = os.path.join(path, item)

            if os.path.isdir(item_path):
                all_files += list_all_files_recursively(item_path)

            else:
                all_files.append(item)

    else:
        print(path, ": does not exist")
        return []

    return all_files

if __name__ == '__main__':
    print(list_all_files_recursively(r"/"))