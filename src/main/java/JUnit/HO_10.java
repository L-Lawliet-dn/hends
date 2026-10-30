package JUnit;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double balanceAfterWithdrawal(double withdrawAmt)
            throws NotEnoughFundsException {
        if (withdrawAmt > balance) {
            throw new NotEnoughFundsException("Insufficient funds.");
        }

        balance -= withdrawAmt;
        return balance;
    }
}

class NotEnoughFundsException extends Exception {
    public NotEnoughFundsException(String message) {
        super(message);
    }
}