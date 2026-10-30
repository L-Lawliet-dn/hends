fruit_prices = {
    "apple": 120,
    "banana": 50,
    "mango": 150,
    "orange": 80,
    "grapes": 90
}

fruit_name = input("Enter a fruit name: ").lower()

if fruit_name in fruit_prices:
    print(f"{fruit_name.title()} is available.")
    print(f"Price: ₹{fruit_prices[fruit_name]}")
else:
    print(f"{fruit_name.title()} is not available.")