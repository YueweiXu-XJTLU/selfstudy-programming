def str_reverse(s):
    return s[::-1]

def sub_str(s, x, y):
    return s[x : y]

if __name__ == '__main__':
    print(str_reverse("abc"))
    print(sub_str("abcabc", 0, 3))