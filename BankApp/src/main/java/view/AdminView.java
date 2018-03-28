package view;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame {

    private JButton btnCreateEmployee;
    private JButton btnReadEmployee;
    private JButton btnUpdateEmployee;
    private JButton btnDeleteEmployee;

    public AdminView() throws HeadlessException {

        setSize(300, 350);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(null);
        add(btnCreateEmployee);
        add(btnReadEmployee);
        add(btnUpdateEmployee);
        add(btnDeleteEmployee);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(false);

    }

    private void initializeFields() {

        btnCreateEmployee = new JButton("Create employee");
        btnCreateEmployee.setBounds(30, 30, 200, 50);

        btnReadEmployee = new JButton("Display existing employees");
        btnReadEmployee.setBounds(30, 100, 200, 50);

        btnUpdateEmployee = new JButton("Update existing employee");
        btnUpdateEmployee.setBounds(30, 170, 200, 50);

        btnDeleteEmployee = new JButton("Delete employee");
        btnDeleteEmployee.setBounds(30, 240, 200, 50);
    }
}
