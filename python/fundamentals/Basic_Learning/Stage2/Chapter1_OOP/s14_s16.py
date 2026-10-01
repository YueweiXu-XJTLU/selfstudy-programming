# case exercise

import json

class Record:
    date = None
    order_id = None
    money = None
    province = None

    def __init__(self, date, order_id, money, province):
        self.date = date
        self.order_id = order_id
        self.money = money
        self.province = province

    def __str__(self):
        return f"date: {self.date}, order_id: {self.order_id}, money: {self.money}, province: {self.province}"



class FileReader:
    path = None
    record_list = None

    def __init__(self, path):
        self.path = path
        self.record_list = []

    def file_read(self) -> list[Record]:
        pass



class TextFileReader(FileReader):
    def file_read(self) -> list[Record]:
        file = open(self.path, "r", encoding="utf-8")
        for line in file:
            line = line.strip().split(",")
            record = Record(line[0], line[1], line[2], line[3])
            self.record_list.append(record)
        file.close()
        return self.record_list



class JsonFileReader(FileReader):
    def file_read(self) -> list[Record]:
        file = open(self.path, "r", encoding="utf-8")
        for line in file:
            data_dict = json.loads(line)
            record = Record(data_dict["date"], data_dict["order_id"], data_dict["money"], data_dict["province"])
            self.record_list.append(record)
        file.close()
        return self.record_list



if __name__ == "__main__":
    text_file_reader = TextFileReader("2011年1月销售数据.txt")
    jan_data = text_file_reader.file_read() # type: list[Record]
    # for record in jan_data:
    #     print(record)

    json_file_reader = JsonFileReader("2011年2月销售数据JSON.txt")
    feb_data = json_file_reader.file_read() # type: list[Record]
    # for record in feb_data:
    #     print(record)

    all_data = jan_data + feb_data # type: list[Record]

    result = dict()

    for record in all_data:
        if record.date in result:
            result[record.date] += int(record.money)
        else:
            result[record.date] = int(record.money)

    print(result)