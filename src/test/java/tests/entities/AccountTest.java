package tests.entities;

import com.student.luisf.entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.factory.AccountFactory;

public class AccountTest {
    @Test
    public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
        //Arrange
        double amount = 200.0;
        double expectedValue = 196.0;
        Account acc = AccountFactory.createEmptyAccount();

        //Act
        acc.deposit(amount);

        //Assert
        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void depositShouldDoNothingWhenNegativeAmmount() {
        //Arrange
        double amount = -200.0;
        double expectedValue = 100.0;
        Account acc = AccountFactory.createAccount(expectedValue);

        //Act
        acc.deposit(amount);

        //assert
        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void depositShouldFullWithDrawAndReturnFullBalance() {
        //Arrange
        double initialBalance = 800.0;
        double expectedValue = 0.0;
        Account acc = AccountFactory.createAccount(initialBalance);

        //Act
        double result = acc.fullWithDraw();

        //Assert
        Assertions.assertTrue(expectedValue == acc.getBalance());
        Assertions.assertTrue(result == initialBalance);
    }
}
