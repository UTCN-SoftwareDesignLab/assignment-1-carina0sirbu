package repository;

import model.Customer;
import model.validation.Notification;
import repository.EntityNotFoundException;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    Customer findById(String name) throws EntityNotFoundException;

    Customer findById(Long id) throws EntityNotFoundException;


    boolean save(Customer customer);

    void removeAll();

    boolean update(Customer customer);

    boolean delete(Long id);
}
