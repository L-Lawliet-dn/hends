print("Enter a list of numbers to get the sum of")
arr = []
while True:
    arr.append(int(input("Enter a number to add: ")))

    redo = input("Do you want to add more numbers (Y/N)").upper()

    if redo != "Y":
        break

print(f"The sum of the array {arr} is {sum(arr)}")