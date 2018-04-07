package service;

import model.Customer;
import model.validation.Notification;
import repository.EntityNotFoundException;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(String name) throws EntityNotFoundException;

    Customer findById(Long id) throws EntityNotFoundException;

    Boolean save(Customer book);

    boolean update(Customer customer);

    boolean delete(Long id);
}
