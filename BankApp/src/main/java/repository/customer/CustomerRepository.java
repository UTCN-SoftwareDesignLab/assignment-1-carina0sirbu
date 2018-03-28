package repository.customer;

import model.Account;
import model.Customer;
import repository.EntityNotFoundException;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    Customer findById(Long id) throws EntityNotFoundException;

    boolean save(Customer customer);

    void removeAll();
}
