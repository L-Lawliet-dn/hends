import HO_33
import unittest

class TestCalc(unittest.TestCase):

    def test_add_func(self):
        # Sum tests
        self.assertEqual(HO_33.sum(2, 3) , 5)
        self.assertEqual(HO_33.sum(-4, 6) , 2)

    def test_sub_func(self):
        # Subtraction tests
        self.assertEqual(HO_33.difference(10, 4),6)
        self.assertEqual(HO_33.difference(3, 8) , -5)

    def test_prod_func(self):
        # Product tests
        self.assertEqual(HO_33.product(4, 5),20)
        self.assertEqual(HO_33.product(8, 0) , 0)

    def test_div_func(self):
        # Division tests
        self.assertEqual(HO_33.quotient(10, 2) , 5)
        self.assertEqual(HO_33.quotient(7, 2) , 3.5)
        self.assertEqual(HO_33.quotient(10, 0) , None)
