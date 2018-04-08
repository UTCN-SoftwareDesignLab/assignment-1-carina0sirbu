package repository.account;

import database.DBConnectionFactory;
import model.Account;
import model.Customer;
import model.builder.AccountBuilder;
import model.builder.CustomerBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class AccountRepositoryMySQLTest {

    private static AccountRepository accountRepository;

    @Before
    public void setUp() throws Exception {

        accountRepository = new AccountRepositoryMySQL(new DBConnectionFactory().getConnectionWrapper(true).getConnection());

        accountRepository.save("1", new AccountBuilder()
                                                .setId((long) 1)
                                                .setType("spending")
                                                .setSum(125)
                                                .setCreationDate(new Date(System.currentTimeMillis()))
                                                .setCustomerId((long) 1)
                                                .build());
    }

    @Test
    public void findById() {

        accountRepository.save("3", new AccountBuilder()
                .setId((long) 1)
                .setType("spending")
                .setSum(125)
                .setCreationDate(new Date(System.currentTimeMillis()))
                .setCustomerId((long) 3)
                .build());

        Account account = accountRepository.findById((long)1);

        assertEquals(account.getType(), "spending");
        assertEquals(account.getSum(), 125);
    }

    @Test
    public void save() {

        assertTrue(accountRepository.save("2", new AccountBuilder()
                .setId((long) 1)
                .setType("spending")
                .setSum(125)
                .setCreationDate(new Date(System.currentTimeMillis()))
                .setCustomerId((long) 2)
                .build()));
    }


    @Test
    public void delete() {

        accountRepository.save("5", new AccountBuilder()
                .setId((long) 1)
                .setType("spending")
                .setSum(125)
                .setCreationDate(new Date(System.currentTimeMillis()))
                .setCustomerId((long) 5)
                .build());

        accountRepository.delete((long) 1);
    }
}