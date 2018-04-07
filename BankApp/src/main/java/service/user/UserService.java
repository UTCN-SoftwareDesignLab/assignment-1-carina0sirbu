package service.user;

import model.User;

import java.util.List;
import java.util.SplittableRandom;

public interface UserService {

    List<User> findAll();

    boolean delete(Long id);

    boolean update(Long id, String username);

    Long findIdByUsername(String username);
}
