package view;


import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class CustomerView extends JFrame {

    private JPanel contentPane;

    private JTable table;
    private DefaultTableModel model;

    private JButton btnSearchCustomer;
    private JButton btnDeleteCustomer;
    private JButton btnUpdateCustomer;
    private JButton btnAddCustomer;

    private JButton btnAddAccount;
    private JButton btnUpdateAccount;
    private JButton btnDeleteAccount;
    private JButton btnPayBill;
    private JButton btnTransfer;

    private JTextField txtIdentityCard;
    private JTextField txtPersNumCode;
    private JTextField txtSum;
    private JTextField txtBillAmount;
    private JTextField txtName;
    private JTextField txtTransfer;

    private JRadioButton spendingAcc;
    private JRadioButton savingAcc;

    private JComboBox<Long> accountId1;
    private JComboBox<Long> accountId2;


    public CustomerView() throws HeadlessException {


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 567, 464);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        contentPane.setLayout(null);

        btnTransfer = new JButton("Transfer");
        btnTransfer.setBounds(400, 75, 115, 23);
        contentPane.add(btnTransfer);

        JLabel lblTransfer = new JLabel("Amount:");
        lblTransfer.setBounds(400, 40, 60, 23);
        contentPane.add(lblTransfer);

        txtTransfer = new JTextField("");
        txtTransfer.setBounds(460, 40, 55, 23);
        contentPane.add(txtTransfer);

        accountId1 = new JComboBox<Long>();
        accountId1.setBounds(400, 10, 50, 23);
        contentPane.add(accountId1);

        accountId2 = new JComboBox<Long>();
        accountId2.setBounds(465, 10, 50, 23);
        contentPane.add(accountId2);

        txtName = new JTextField();
        txtName.setBounds(56, 11, 213, 20);
        contentPane.add(txtName);
        txtName.setColumns(10);

        JLabel lblNewLabel = new JLabel("Name:");
        lblNewLabel.setBounds(10, 14, 57, 14);
        contentPane.add(lblNewLabel);

        btnSearchCustomer = new JButton("Search");
        btnSearchCustomer.setBounds(279, 10, 89, 23);
        contentPane.add(btnSearchCustomer);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(34, 177, 291, 150);
        contentPane.add(scrollPane);

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Type");
        model.addColumn("Balance");

        table = new JTable();
        table.setModel(model);

        scrollPane.setViewportView(table);


        txtIdentityCard = new JTextField();
        txtIdentityCard.setBounds(66, 42, 169, 20);
        contentPane.add(txtIdentityCard);
        txtIdentityCard.setColumns(10);

        txtPersNumCode = new JTextField();
        txtPersNumCode.setColumns(10);
        txtPersNumCode.setBounds(66, 74, 169, 20);
        contentPane.add(txtPersNumCode);

        JLabel lblCardId = new JLabel("ID Card:");
        lblCardId.setHorizontalAlignment(SwingConstants.TRAILING);
        lblCardId.setBounds(0, 45, 57, 14);
        contentPane.add(lblCardId);

        JLabel lblPnc = new JLabel("PNC:");
        lblPnc.setHorizontalAlignment(SwingConstants.TRAILING);
        lblPnc.setBounds(0, 77, 57, 14);
        contentPane.add(lblPnc);

        btnDeleteCustomer = new JButton("Delete");
        btnDeleteCustomer.setBounds(133, 105, 89, 23);
        contentPane.add(btnDeleteCustomer);

        btnUpdateCustomer = new JButton("Update");
        btnUpdateCustomer.setBounds(245, 105, 89, 23);
        contentPane.add(btnUpdateCustomer);


        btnAddCustomer = new JButton("Add");
        btnAddCustomer.setBounds(10, 105, 89, 23);
        contentPane.add(btnAddCustomer);

        JLabel lblAcconts = new JLabel("Accounts:");
        lblAcconts.setBounds(10, 139, 74, 14);
        contentPane.add(lblAcconts);

        btnUpdateAccount = new JButton("Update ");
        btnUpdateAccount.setBounds(245, 380, 89, 23);
        contentPane.add(btnUpdateAccount);

        btnDeleteAccount = new JButton("Delete");
        btnDeleteAccount.setBounds(133, 380, 89, 23);
        contentPane.add(btnDeleteAccount);

        btnAddAccount = new JButton("Add");
        btnAddAccount.setBounds(10, 380, 89, 23);
        contentPane.add(btnAddAccount);

        txtSum = new JTextField();
        txtSum.setBounds(283, 353, 51, 20);
        txtSum.setEditable(false);
        contentPane.add(txtSum);
        txtSum.setColumns(10);

        JLabel lblSum = new JLabel("Sum:");
        lblSum.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSum.setBounds(227, 355, 46, 14);
        contentPane.add(lblSum);



        JLabel labelBill = new JLabel("<html>Select account and <br/>insert bill amount</html>", SwingConstants.CENTER);
        labelBill.setBounds(350, 150, 150, 60);
        contentPane.add(labelBill);

        txtBillAmount = new JTextField();
        txtBillAmount.setBounds(340, 220, 50, 20);
        contentPane.add(txtBillAmount);

        btnPayBill = new JButton("Process");
        btnPayBill.setBounds(400, 220, 100, 30);
        contentPane.add(btnPayBill);

        spendingAcc = new JRadioButton("Spending Account");
        spendingAcc.setBounds(350, 250, 150, 50);
        contentPane.add(spendingAcc);


        savingAcc = new JRadioButton("Saving Account");
        savingAcc.setBounds(350, 280, 150, 50);
        contentPane.add(savingAcc);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(savingAcc);
        buttonGroup.add(spendingAcc);

        contentPane.setVisible(true);
    }

    public void setBtnAddCustomerListener(ActionListener addCustomerListener) {
        btnAddCustomer.addActionListener(addCustomerListener);
    }

    public void setBtnSearchCustomerListener(ActionListener searchCustomerListener) {
        btnSearchCustomer.addActionListener(searchCustomerListener);
    }

    public void setBtnUpdateCustomerListener(ActionListener updateCustomerListener) {
        btnUpdateCustomer.addActionListener(updateCustomerListener);
    }

    public void setBtnDeleteCustomerListener(ActionListener deleteCustomerListener) {
        btnDeleteCustomer.addActionListener(deleteCustomerListener);
    }

    public void setBtnAddAccountListener(ActionListener addAccountListener) {
        btnAddAccount.addActionListener(addAccountListener);
    }


    public void setBtnUpdateAccountListener(ActionListener updateAccountListener) {
        btnUpdateAccount.addActionListener(updateAccountListener);
    }

    public void setBtnDeleteAccountListener(ActionListener deleteAccountListener) {
        btnDeleteAccount.addActionListener(deleteAccountListener);
    }

    public void setBtnSpendingAccListener(ActionListener spendingAccListener) {
        spendingAcc.addActionListener(spendingAccListener);
    }

    public void setBtnSavingAccListener(ActionListener savingAccListener) {
        savingAcc.addActionListener(savingAccListener);
    }

    public void setBtnPayBillListener(ActionListener payBillListener) {
        btnPayBill.addActionListener(payBillListener);
    }

    public void setBtnTransferListener(ActionListener transferListener) {
        btnTransfer.addActionListener(transferListener);
    }

    public String getNameText() {
        return txtName.getText();
    }

    public String getIdentityCardText() {
        return txtIdentityCard.getText();
    }

    public String getPersNumCodeText() {
        return txtPersNumCode.getText();
    }

    public String getSumText() {
        return txtSum.getText();
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setTxtIdentityCard(String identityCard) {
        txtIdentityCard.setText(identityCard);
    }

    public void setTxtPersNumCode(String persNumCode) {
        txtPersNumCode.setText(persNumCode);
    }

    public String getSavingButtonText() {
        return "saving";
    }

    public String getSpendingButtonText() {
        return "spending";
    }

    public boolean getSavingButtonState() {

        return savingAcc.isSelected();

    }

    public boolean getSpendingButtonState() {
        return spendingAcc.isSelected();
    }

    public void setSumTextAvailable() {
        txtSum.setEditable(true);
    }

    public void setSumTextUnavailable() {
        txtSum.setEditable(false);
    }

    public String getTxtBillAmount() {
        return txtBillAmount.getText();
    }

    public String getTxtTransfer() {
        return txtTransfer.getText();
    }

    public JComboBox<Long> getAccountId1() {
        return accountId1;
    }

    public void setAccountId1(JComboBox<Long> accountId1) {
        this.accountId1 = accountId1;
    }

    public JComboBox<Long> getAccountId2() {
        return accountId2;
    }

    public void setAccountId2(JComboBox<Long> accountId2) {
        this.accountId2 = accountId2;
    }

}


