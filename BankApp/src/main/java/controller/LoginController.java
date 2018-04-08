package controller;

import model.Customer;
import model.User;
import model.validation.Notification;
import repository.user.AuthenticationException;
import service.user.AuthenticationService;
import view.CustomerView;
import view.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ControllerFeature {

    private static final String ADMIN_USERNAME = "carina.sirbu@gmail.com";
    private final LoginView loginView;
    private final AuthenticationService authenticationService;

    private final CustomerController customerController;
    private final AdminController adminController;

    public LoginController(LoginView loginView,
                           AuthenticationService authenticationService,
                           CustomerController customerController,
                           AdminController adminController) {

        this.loginView = loginView;

        this.authenticationService = authenticationService;

        this.customerController = customerController;
        this.adminController = adminController;

        loginView.setLoginButtonListener(new LoginButtonListener());
        loginView.setRegisterButtonListener(new RegisterButtonListener());
    }

    @Override
    public void setViewVisible() {

        loginView.setVisible(true);
    }

    private class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            String username = loginView.getUsername();
            String password = loginView.getPassword();



            Notification<User> loginNotification = null;
            try {
                loginNotification = authenticationService.login(username, password);
            } catch (AuthenticationException e1) {
                e1.printStackTrace();
            }

            if (loginNotification != null) {
                if (loginNotification.hasErrors()) {
                    JOptionPane.showMessageDialog(loginView.getContentPane(), loginNotification.getFormattedErrors());
                } else {
                    //JOptionPane.showMessageDialog(loginView.getContentPane(), "Login successful!");

                    if (loginView.getUsername().equals(ADMIN_USERNAME)) {
                        adminController.setViewVisible();

                    }
                    else {
                        customerController.setViewVisible();
                    }

                }
            }
        }
    }

    private class RegisterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginView.getUsername();
            String password = loginView.getPassword();

            Notification<Boolean> registerNotification = authenticationService.register(username, password);
            if (registerNotification.hasErrors()) {
                JOptionPane.showMessageDialog(loginView.getContentPane(), registerNotification.getFormattedErrors());
            } else {
                if (!registerNotification.getResult()) {
                    JOptionPane.showMessageDialog(loginView.getContentPane(), "Registration not successful, please try again later.");
                } else {
                    JOptionPane.showMessageDialog(loginView.getContentPane(), "Registration successful!");
                }
            }
        }
    }


}
