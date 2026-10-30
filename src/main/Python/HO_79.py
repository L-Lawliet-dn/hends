import pytest
import HO_33

def test_add_func():
    # Sum tests
    assert HO_33.sum(2, 3) ==  5
    assert HO_33.sum(-4, 6) == 2

def test_sub_func():
    # Subtraction tests
    assert HO_33.difference(10, 4)==6
    assert HO_33.difference(3, 8) == -5

@pytest.mark.activity
def test_prod_func():
    # Product tests
    assert HO_33.product(4, 5)==20
    assert HO_33.product(8, 0) == 0

@pytest.mark.activity
def test_div_func():
    # Division tests
    assert HO_33.quotient(10, 2) == 5
    assert HO_33.quotient(7, 2) == 3.5
    assert HO_33.quotient(10, 0) == None