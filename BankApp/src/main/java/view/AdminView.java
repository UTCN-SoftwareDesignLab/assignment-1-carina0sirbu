package view;

import model.Action;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdminView extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;

    private JScrollPane scrollPane;

    private JButton btnUpdateEmployee;
    private JButton btnDeleteEmployee;
    private JButton btnGenerateReports;
    private JButton btnShowEmployee;

    public AdminView() throws HeadlessException {


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 492, 513);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        contentPane.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 75, 452, 350);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        model = new DefaultTableModel();
        model.addColumn("CLIENT ID");
        model.addColumn("USERNAME");
        table.setModel(model);

        btnUpdateEmployee = new JButton("Update  Employee");
        btnUpdateEmployee.setBounds(10, 11, 140, 53);
        contentPane.add(btnUpdateEmployee);

        btnDeleteEmployee = new JButton("Delete Employee");
        btnDeleteEmployee.setBounds(330, 11, 140, 53);
        contentPane.add(btnDeleteEmployee);

        btnShowEmployee = new JButton("Show Employees");
        btnShowEmployee.setBounds(170, 11, 140, 53);
        contentPane.add(btnShowEmployee);

        btnGenerateReports = new JButton("Generate Report");
        btnGenerateReports.setBounds(10, 436, 452, 23);
        contentPane.add(btnGenerateReports);
    }

    public void setBtnUpdateEmployeeListener(ActionListener updateEmployeeListener) {
        btnUpdateEmployee.addActionListener(updateEmployeeListener);
    }

    public void setBtnDeleteEmployeeListener(ActionListener deleteEmployeeListener) {
        btnDeleteEmployee.addActionListener(deleteEmployeeListener);
    }

    public void setBtnGenerateReportsListener(ActionListener generateReportsListener) {
        btnGenerateReports.addActionListener(generateReportsListener);
    }

    public void setBtnShowEmployeeListener(ActionListener showEmployeeListener) {
        btnShowEmployee.addActionListener(showEmployeeListener);
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getModel() {
        return model;
    }


}
