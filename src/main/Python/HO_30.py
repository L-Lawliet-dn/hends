class Car:
    def __init__(self, brand, model, year, color, price):
        self.brand = brand
        self.model = model
        self.year = year
        self.color = color
        self.price = price
        self.is_running = False

    def start(self):
        self.is_running = True
        print(f"{self.brand} {self.model} has started.")

    def stop(self):
        self.is_running = False
        print(f"{self.brand} {self.model} has stopped.")

    def display_details(self):
        print(f"Brand: {self.brand}")
        print(f"Model: {self.model}")
        print(f"Year: {self.year}")
        print(f"Color: {self.color}")
        print(f"Price: ₹{self.price}")
        print(f"Running: {self.is_running}")
        print("-" * 30)


car_one = Car("Toyota", "Fortuner", 2024, "White", 4500000)
car_two = Car("Honda", "City", 2023, "Black", 1600000)
car_three = Car("Tata", "Nexon", 2024, "Blue", 1200000)
