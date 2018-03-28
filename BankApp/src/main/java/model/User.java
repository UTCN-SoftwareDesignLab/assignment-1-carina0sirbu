package model;

import model.Role;
import java.util.List;

public class User {

    private Long id;
    private String username;
    private String password;
    private List<Role> role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }


}
