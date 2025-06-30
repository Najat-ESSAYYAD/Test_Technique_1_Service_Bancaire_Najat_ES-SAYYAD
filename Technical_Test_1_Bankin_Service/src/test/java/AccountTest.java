import org.example.Account;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
class AccountTest {
    @Test
    void testDepositAndWithdrawAndPrint() {
        Account account = new Account();

        account.deposit(1000, LocalDate.of(2012, 1, 10));
        account.deposit(2000, LocalDate.of(2012, 1, 13));
        account.withdraw(500, LocalDate.of(2012, 1, 14));

        // On pourrait capturer la sortie pour vérifier ou juste vérifier le solde final
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(10000));

        // Le solde final doit être 2500
    }
    @Test
    void testDepositAndWithdraw() {
        Account account = new Account();
        account.deposit(1000);
        account.withdraw(500);
        account.deposit(2000);
    }

    @Test
    void testDepositNegativeAmount() {
        Account account = new Account();
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
    }

    @Test
    void testWithdrawNegativeAmount() {
        Account account = new Account();
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100));
    }

    @Test
    void testWithdrawMoreThanBalance() {
        Account account = new Account();
        account.deposit(1000);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(1500));
    }

    @Test
    void testWithdrawAllBalance() {
        Account account = new Account();
        account.deposit(1000);
        account.withdraw(1000);
    }

    @Test
    void testPrintStatementEmpty() {
        Account account = new Account();
        account.printStatement();
    }

    @Test
    void testDepositZeroAmount() {
        Account account = new Account();
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
    }

    @Test
    void testWithdrawZeroAmount() {
        Account account = new Account();
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
    }
}
