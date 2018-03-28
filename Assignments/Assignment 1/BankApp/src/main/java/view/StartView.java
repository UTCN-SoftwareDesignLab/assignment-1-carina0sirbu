package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartView extends JFrame {

    private JLabel bankApp;
    private JButton btnEmployee;
    private JButton btnAdmin;
    private JButton btnNew;

    public StartView() throws HeadlessException {

        setSize(400, 400);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(null);
        add(bankApp);
        add(btnEmployee);
        add(btnAdmin);
        add(btnNew);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeFields() {

        bankApp = new JLabel("Bank Application");
        bankApp.setBounds(160, 60, 200, 100);

        btnEmployee = new JButton("EMPLOYEE");
        btnEmployee.setBounds(40, 238, 150, 50);

        btnAdmin = new JButton("ADMINISTRATOR");
        btnAdmin.setBounds(200, 238, 150, 50);

        btnNew = new JButton("Not registered?");
        btnNew.setBounds(120, 160, 150, 50);
    }

    public void setBtnEmployeeListener(ActionListener btnEmployeeListener) {
        btnEmployee.addActionListener(btnEmployeeListener);
    }

    public void setBtnAdminListener(ActionListener btnAdminListener) {
        btnAdmin.addActionListener(btnAdminListener);
    }

    public void setBtnNewListener(ActionListener btnNewListener) {
        btnNew.addActionListener(btnNewListener);
    }
}
