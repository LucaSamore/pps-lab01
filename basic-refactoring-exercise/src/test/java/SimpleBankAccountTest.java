import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
final class SimpleBankAccountTest {

    private static final double AMOUNT = 100;
    private static final double AMOUNT_TO_WITHDRAW = 70;
    private static final double EMPTY_BALANCE = 0;
    private static final int WRONG_HOLDER_ID = 2;

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, EMPTY_BALANCE, 1);
    }

    @Test
    void testInitialBalance() {
        assertEquals(EMPTY_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), AMOUNT);
        assertEquals(AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testDepositWithWrongHolderId() {
        bankAccount.deposit(accountHolder.getId(), AMOUNT);
        bankAccount.deposit(WRONG_HOLDER_ID, 50);
        assertEquals(AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testDepositWithWrongAmount() {
        bankAccount.deposit(accountHolder.getId(), -AMOUNT);
        assertEquals(EMPTY_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), AMOUNT_TO_WITHDRAW);
        assertEquals(AMOUNT - AMOUNT_TO_WITHDRAW - bankAccount.getFee(), bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithWrongHolderId() {
        bankAccount.deposit(accountHolder.getId(), AMOUNT);
        bankAccount.withdraw(WRONG_HOLDER_ID, AMOUNT_TO_WITHDRAW);
        assertEquals(AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithWrongAmount() {
        bankAccount.deposit(accountHolder.getId(), AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), 2 * AMOUNT);
        assertEquals(AMOUNT, bankAccount.getBalance());
    }
}
