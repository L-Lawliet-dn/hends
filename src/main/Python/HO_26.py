list_one = [1, 2, 3, 4, 5, 6, 7]
list_two = [10, 11, 12, 13, 14, 15]

odd_numbers = [number for number in list_one if number % 2 != 0]
even_numbers = [number for number in list_two if number % 2 == 0]

new_list = odd_numbers + even_numbers

print("First list:", list_one)
print("Second list:", list_two)
print("New list:", new_list)