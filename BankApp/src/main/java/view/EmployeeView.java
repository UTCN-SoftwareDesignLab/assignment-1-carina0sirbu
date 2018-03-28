package view;

import javax.swing.*;
import java.awt.*;

public class EmployeeView extends JFrame {

    private JButton btnCreateCustomer;
    private JButton btnReadCustomer;
    private JButton btnUpdateCustomer;
    private JButton btnCreateAccount;
    private JButton btnReadAccount;
    private JButton btnUpdateAccount;
    private JButton btnDeleteAccount;

    public EmployeeView() throws HeadlessException {

        setSize(600, 350);
        setLocationRelativeTo(null);
        initializeFiels();
        setLayout(null);
        add(btnCreateCustomer);
        add(btnReadCustomer);
        add(btnUpdateCustomer);
        add(btnCreateAccount);
        add(btnReadAccount);
        add(btnUpdateAccount);
        add(btnDeleteAccount);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(false);

    }

    private void initializeFiels() {

        btnCreateCustomer = new JButton("Create customer");
        btnCreateCustomer.setBounds(40, 40, 250, 50);

        btnReadCustomer = new JButton("View existing customer");
        btnReadCustomer.setBounds(40, 100, 250, 50);

        btnUpdateCustomer = new JButton("Update existing customer");
        btnUpdateCustomer.setBounds(40, 160, 250, 50);

        btnCreateAccount = new JButton("Create account");
        btnCreateAccount.setBounds(320, 40, 250, 50);

        btnReadAccount = new JButton("Display account");
        btnReadAccount.setBounds(320, 100, 250, 50);

        btnUpdateAccount = new JButton("Update account");
        btnUpdateAccount.setBounds(320, 160, 250, 50);

        btnDeleteAccount = new JButton("Delete account");
        btnDeleteAccount.setBounds(320, 220, 250, 50);
    }
}
