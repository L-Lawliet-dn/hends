import unittest

class ArrSum(unittest.TestCase):
    arr = []
    def __init__(self, methodName: str = "runTest") -> None:
        super().__init__(methodName)
        for i in range(0,11):
            self.arr.append(i)

    def test_list_sum(self):
        self.assertEqual(sum(self.arr),55)
