package service.account;

import model.Account;
import repository.EntityNotFoundException;

import java.util.List;

public interface AccountService {


    List<Account> findAll(Long customerId);

    Account findById(Long id) throws EntityNotFoundException;

    boolean save(String customerId, Account account);

    boolean deleteAccount(Long id);

    boolean update(Long id, int sum);

    Account findByAccountId(Long id);
}
