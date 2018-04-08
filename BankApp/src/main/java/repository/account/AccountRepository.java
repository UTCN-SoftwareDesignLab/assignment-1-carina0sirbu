package repository.account;

import model.Account;

import java.util.List;

public interface AccountRepository {

    List<Account> findAll(Long customerId);

    Account findById(Long id);

    boolean save(String customerId, Account account);

    boolean delete(Long id);

    boolean update(Long id, int sum);

    Account findByAccountId(Long id);
}
