package service.account;

import model.Account;
import repository.EntityNotFoundException;
import repository.account.AccountRepository;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Account> findAll(Long customerId) {

        return repository.findAll(customerId);

    }

    @Override
    public Account findById(Long id) throws EntityNotFoundException {
        return repository.findById(id);
    }

    @Override
    public boolean save(String customerId, Account account) {
        return repository.save(customerId, account);
    }

    @Override
    public boolean deleteAccount(Long id) {
        return repository.delete(id);
    }

    @Override
    public boolean update(Long id, int sum) {
        return repository.update(id, sum);
    }

    @Override
    public Account findByAccountId(Long id) {
        return repository.findByAccountId(id);
    }


}
