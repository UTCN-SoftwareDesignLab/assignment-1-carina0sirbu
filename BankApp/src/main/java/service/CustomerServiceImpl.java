package service;

import model.Customer;
import repository.EntityNotFoundException;
import repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(String name) throws EntityNotFoundException {
        return repository.findById(name);
    }

    @Override
    public Customer findById(Long id) throws EntityNotFoundException {
        return repository.findById(id);
    }

    //
    @Override
    public Boolean save(Customer customer) {

        return repository.save(customer);

    }

    @Override
    public boolean update(Customer customer) {
        return repository.update(customer);
    }

    @Override
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}
