import pandas as pd

data_frame = pd.read_excel("employees.xlsx")

print("Original Data:")
print(data_frame)

sorted_data = data_frame.sort_values(by="salary")

print("\nSorted Data by Salary:")
print(sorted_data)