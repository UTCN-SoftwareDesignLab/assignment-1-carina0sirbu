package service.user;

import model.User;
import repository.user.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean delete(Long id) {
        return repository.delete(id);
    }

    @Override
    public boolean update(Long id, String username) {
        return repository.update(id, username);
    }

    @Override
    public Long findIdByUsername(String username) {
        return repository.findIdByUsername(username);
    }
}
