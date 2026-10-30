try:
    print(student_name)
except NameError as error:
    print("A NameError occurred:", error)

print("Program execution continues after handling the error.")