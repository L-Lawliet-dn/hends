from datetime import date

name = input("Enter your name: ")
age = int(input("Enter your age: "))

print(f"The year you ({name}) will turn 100 is {date.today().year+(100-age)}")