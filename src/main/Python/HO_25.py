print("Enter elements of a list")
arr = []

while True:
    uVal = input("Enter a number to add to array or any letter to exit: ")

    if uVal.isnumeric():
        arr.append(int(uVal))
    else:
        break

if arr[0] == arr[-1]:
    print("The first and last values of the array are the same")
else:
    print("The first and last values of the array are not the same")