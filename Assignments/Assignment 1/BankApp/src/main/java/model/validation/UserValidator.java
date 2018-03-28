package model.validation;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UserValidator {

    private static final String EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final int MIN_PASSWORD_LENGTH = 8;

    private final User user;
    private final List<String> errors;

    public List<String> getErrors() {
        return errors;
    }

    public UserValidator(User user) {
        this.user = user;
        errors = new ArrayList<>();
    }

    public boolean validate() {
        return true;
    }

    public void validateUsername(String username) {

        if (!Pattern.compile(EMAIL_VALIDATION_REGEX).matcher(username).matches()) {
            errors.add("Invalid Email");
        }
    }

    public void validatePassword(String password) {

        if (password.length() < MIN_PASSWORD_LENGTH) {
            errors.add("Password too short");
        }
        if (!containsSpecialCharacter(password)) {
            errors.add("Password must contain at least one special character");
        }
        if (!containsDigit(password)) {
            errors.add("Password must containt at least one digit");
        }
    }

    private boolean containsSpecialCharacter (String s) {

        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m  = p.matcher(s);
        return m.find();
    }

    private static boolean containsDigit (String s) {

        if (s != null && !s.isEmpty()) {
            for(char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    return true;
                }
            }
        }

        return false;
    }
}
