package repository.account;

import model.Account;
import model.Customer;
import repository.EntityNotFoundException;

import java.util.List;

public interface AccountRepository {

    List<Account> findAll(Customer customer);

    boolean save(Customer customer, Account account);

    boolean delete(Customer customer, Account account);

    boolean update(Customer customer, Account account);
}
