import pandas as pd

data_frame = pd.read_csv("users.csv")

print("Full DataFrame:")
print(data_frame)

print("\nUsernames:")
print(data_frame["username"])

print("\nPasswords:")
print(data_frame["password"])