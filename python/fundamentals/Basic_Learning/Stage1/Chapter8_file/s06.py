# exercise
bill_bak = open("bill.txt.bak", "a", encoding="utf-8")

with open("bill.txt", "r", encoding="utf-8") as file:
    for line in file:
        contents = line.split(",")
        for item in contents:
            if item == "正式\n" or item == "正式":
                bill_bak.write(line)

bill_bak.close()