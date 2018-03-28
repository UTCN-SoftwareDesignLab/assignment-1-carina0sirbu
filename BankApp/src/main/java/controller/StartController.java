package controller;


import view.StartView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartController {

    private final StartView startView;
    private final LoginController loginController;
    private final EmployeeController employeeController;
    private final AdminController adminController;

    public StartController(StartView startView, LoginController loginController, EmployeeController employeeController, AdminController adminController) {
        this.startView = startView;

        this.loginController = loginController;
        this.employeeController = employeeController;
        this.adminController = adminController;

        startView.setBtnAdminListener(new AdminButtonListener());
        startView.setBtnEmployeeListener(new EmployeeButtonListener());
        startView.setBtnNewListener(new NewButtonListener());
    }


    private class AdminButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            adminController.setViewVisible();
        }
    }

    private class EmployeeButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            employeeController.setViewVisible();
        }
    }

    private class NewButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            loginController.setViewVisible();
        }
    }
}
