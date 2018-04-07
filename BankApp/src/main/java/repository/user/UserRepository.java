package repository.user;

import model.User;
import model.validation.Notification;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    Notification<User> findByUsernameAndPassword(String username, String password) throws AuthenticationException;

    Long findIdByUsername(String username);

    boolean save(User user);

    boolean delete(Long id);

    boolean update(Long id, String username);

    void removeAll();
}
