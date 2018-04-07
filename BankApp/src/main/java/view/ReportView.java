package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class ReportView extends JFrame{

    private JPanel contentPane;
    private JTextField txtUsername;
    private JTextArea txtTextReport;

    public ReportView() throws HeadlessException{

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 309, 355);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        contentPane.setLayout(null);

        txtUsername = new JTextField();
        txtUsername.setText("username");
        txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
        txtUsername.setEditable(false);
        txtUsername.setEnabled(false);
        txtUsername.setBounds(10, 35, 276, 20);
        contentPane.add(txtUsername);
        txtUsername.setColumns(10);

        JLabel lblEmployeeActivityReport = new JLabel("Employee activity report for:");
        lblEmployeeActivityReport.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmployeeActivityReport.setBounds(10, 11, 276, 14);
        contentPane.add(lblEmployeeActivityReport);

        txtTextReport = new JTextArea();
        txtTextReport.setBounds(10, 66, 276, 243);
        contentPane.add(txtTextReport);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 66, 276, 243);
        scrollPane.setViewportView(txtTextReport);
        contentPane.add(scrollPane);

        contentPane.setVisible(true);
    }

    public void setEmployeeNameText(String name) {
        txtUsername.setText(name);
    }

    public void setTxtReport (String report) {
        txtTextReport.setText(report);
    }

    public String getTxtReport() {
        return txtTextReport.getText();
    }

}
