# json
# data (str) encapsulated to transfer between programing languages
# json is a python list, or a python list stuffed with dict
import json

data_python = [{"name":"san.zhang", "age":29}, {"name":"si.li", "age":30}]

# python ---> json
data_json = json.dumps(data_python)
print(data_json, type(data_json))

# json ---> python
data_python = json.loads(data_json)
print(data_python, type(data_python))