import pytest

@pytest.fixture
def wallet():
    amount = 0
    return amount


@pytest.mark.parametrize(
    "input_amount, expected_amount",
    [
        (10, 10),
        (25, 25),
        (100, 100),
        (-10,-10)
    ],
)


def test_wallet_amount(wallet, input_amount, expected_amount):
    wallet += input_amount

    assert wallet == expected_amount