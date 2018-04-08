package repository;

import database.DBConnectionFactory;
import model.Customer;
import model.builder.CustomerBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerRepositoryMySQLTest {

    private static CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {

        customerRepository = new CustomerRepositoryMySQL(new DBConnectionFactory().getConnectionWrapper(true).getConnection());

        customerRepository.save(new CustomerBuilder()
                .setId((long) 1)
                .setName("Daniela")
                .setIdentityCard("234576")
                .setPersNumCode("296085746352")
                .build());
    }

    @Test
    public void save() {

        assertTrue(customerRepository.save(new CustomerBuilder()
                .setId((long) 1)
                .setName("Daniela")
                .setIdentityCard("234576")
                .setPersNumCode("296085746352")
                .build()));
    }


    @Test
    public void findById() throws EntityNotFoundException {

        customerRepository.save(new CustomerBuilder()
                .setId((long) 1)
                .setName("Daniela")
                .setIdentityCard("234576")
                .setPersNumCode("296085746352")
                .build());

        Customer customer = customerRepository.findById("Daniela");

        assertEquals(customer.getName(), "Daniela");
        assertEquals(customer.getIdentityCard(), "234576");
        assertEquals(customer.getPersNumCode(), "296085746352");

    }

    @Test
    public void update() {

        Long id = new Long(3);

        Customer customer = new CustomerBuilder()
                                .setId(id)
                                .setName("Daniela Natalia")
                                .setIdentityCard("234576")
                                .setPersNumCode("296085746352")
                                .build();

        assertTrue(customerRepository.update(customer));
    }
}