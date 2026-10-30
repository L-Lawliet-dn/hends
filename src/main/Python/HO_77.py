import pandas

dict_info = {
    "name": ["Alice", "Bob", "Charlie", "Diana"],
    "age": [25, 30, 35, 28],
    "city": ["New York", "London", "Paris", "Tokyo"],
    "salary": [70000, 85000, 90000, 78000],
}

df = pandas.DataFrame(dict_info)

print(df)