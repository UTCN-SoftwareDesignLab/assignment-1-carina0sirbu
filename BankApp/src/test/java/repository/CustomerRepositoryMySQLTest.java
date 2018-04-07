package repository;

import database.DBConnectionFactory;
import model.builder.CustomerBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerRepositoryMySQLTest {

    private static CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {

        customerRepository = new CustomerRepositoryMySQL(new DBConnectionFactory().getConnectionWrapper(true).getConnection());

    }

    @Test
    public void findById() {


    }

    @Test
    public void save() {

        assertTrue(customerRepository.save(new CustomerBuilder()
                                                .setName("Daniela")
                                                .setIdentityCard("234576")
                                                .setPersNumCode("296085746352")
                                                .build()));
    }

    @Test
    public void delete() {
    }
}