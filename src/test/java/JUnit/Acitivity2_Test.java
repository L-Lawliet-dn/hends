package JUnit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class Activity2 {

    @Test
    void notEnoughFunds() {
        BankAccount account = new BankAccount(10);

        assertThrows(
                NotEnoughFundsException.class,
                () -> account.balanceAfterWithdrawal(20)
        );
    }

    @Test
    void enoughFunds() {
        BankAccount account = new BankAccount(100);

        assertDoesNotThrow(
                () -> account.balanceAfterWithdrawal(20)
        );
    }
}