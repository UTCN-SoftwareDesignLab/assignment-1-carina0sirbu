package controller;


import model.Account;
import model.Action;
import model.Customer;
import model.builder.AccountBuilder;
import model.builder.ActionBuilder;
import model.builder.CustomerBuilder;

import repository.EntityNotFoundException;

import service.account.AccountServiceImpl;
import service.action.ActionServiceImpl;
import service.CustomerServiceImpl;
import service.user.UserServiceImpl;
import view.CustomerView;
import view.LoginView;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;
import java.util.List;

public class CustomerController implements ControllerFeature{

    private final CustomerView customerView;
    private final LoginView loginView;

    private final CustomerServiceImpl customerService;
    private final AccountServiceImpl accountService;
    private final ActionServiceImpl actionService;
    private final UserServiceImpl userService;

    private static Long currentId;


    public CustomerController(CustomerView customerView,
                              LoginView loginView,
                              CustomerServiceImpl customerService,
                              AccountServiceImpl accountService,
                              ActionServiceImpl actionService,
                              UserServiceImpl userService) {

        this.customerView = customerView;
        this.loginView = loginView;
        this.customerService = customerService;
        this.accountService = accountService;
        this.actionService = actionService;
        this.userService = userService;

        customerView.setBtnAddAccountListener(new AddAccountListener());
        customerView.setBtnAddCustomerListener(new AddCustomerListener());
        customerView.setBtnDeleteAccountListener(new DeleteAccountListener());
        customerView.setBtnDeleteCustomerListener(new DeleteCustomerListener());
        customerView.setBtnSearchCustomerListener(new SearchCustomerListener());
        customerView.setBtnUpdateAccountListener(new UpdateAccountListener());
        customerView.setBtnUpdateCustomerListener(new UpdateCustomerListener());
        customerView.setBtnSpendingAccListener(new SpendingAccountListener());
        customerView.setBtnSavingAccListener(new SavingAccountListener());
    }


    @Override
    public void setViewVisible() {
        customerView.setVisible(true);
    }

    private void updateTable() {



        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Type");
        model.addColumn("Balance");

        String customerName = customerView.getNameText();

        try {

            List<Account> accounts = accountService.findAll(customerService.findById(customerName).getId());

            for(Account acc : accounts)
            {
                Object[] obj = {acc.getId(), acc.getType(), acc.getSum()};
                model.addRow(obj);
            }

            customerView.getTable().setModel(model);



            System.out.println("Updated table");

        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }


    }

    private class AddAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {



            String customerName = customerView.getNameText();

            try {
                Customer customer = customerService.findById(customerName);

                String type = new String();
                int sum = 0;
                boolean add = false;

                if (customerView.getSavingButtonState()) {
                    type = customerView.getSavingButtonText();
                    add = true;

                }
                if (customerView.getSpendingButtonState()){
                    type = customerView.getSpendingButtonText();
                    sum = Integer.parseInt(customerView.getSumText());
                    customerView.setSumTextAvailable();
                    add = true;
                }
                else {
                    JOptionPane.showMessageDialog(customerView,"Please choose a type");
                }

                if (add) {
                    Account account = new AccountBuilder()
                            .setSum(sum)
                            .setCreationDate(new Date(System.currentTimeMillis()))
                            .setType(type)
                            .setCustomerId(customer.getId())
                            .build();


                    boolean flag = accountService.save(customer.getId().toString(), account);

                    if (flag) {
                        JOptionPane.showMessageDialog(customerView, "Account added successfully");
                        updateTable();
                    } else {
                        JOptionPane.showMessageDialog(customerView, "Error adding the account");
                    }

                }
            } catch (EntityNotFoundException e1) {
                e1.printStackTrace();
            }
            generateAction("Added new account to customer");


        }
    }

    private class AddCustomerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {



            Customer customer = new CustomerBuilder()
                    .setName(customerView.getNameText())
                    .setIdentityCard(customerView.getIdentityCardText())
                    .setPersNumCode(customerView.getPersNumCodeText())
                    .build();

            if (customerService.save(customer)) {
                JOptionPane.showMessageDialog(customerView,"Customer added to the system");
            } else {
                JOptionPane.showMessageDialog(customerView,"Please try again");
            }
            generateAction("Added new customer to system");
        }
    }

    private class DeleteAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {



            int row = customerView.getTable().getSelectedRow();


            Long accountId = (Long)customerView.getTable().getValueAt(row, 0);

            if (accountService.deleteAccount(accountId)) {
                JOptionPane.showMessageDialog(customerView,"Account deleted!");
            }
            else {
                JOptionPane.showMessageDialog(customerView,"Error while trying to delete");
            }

            ((DefaultTableModel)customerView.getTable().getModel()).removeRow(row);

            generateAction("Deleted account for customer");
        }
    }

    private class DeleteCustomerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String name = customerView.getNameText();
            try {
                Customer customer = customerService.findById(name);

                if (customerService.delete(customer.getId())) {
                    JOptionPane.showMessageDialog(customerView,"Customer deleted!");
                }
                else {
                    JOptionPane.showMessageDialog(customerView,"Error while trying to delete");
                }
            } catch (EntityNotFoundException e1) {
                e1.printStackTrace();
            }

            generateAction("Deleted customer from the system");


        }
    }

    private class SearchCustomerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String customerName = customerView.getNameText();

            try {

                Customer customer = customerService.findById(customerName);

                currentId = customer.getId();

                String idCard = customer.getIdentityCard();
                String persNumCode = customer.getPersNumCode();

                customerView.setTxtIdentityCard(idCard);
                customerView.setTxtPersNumCode(persNumCode);

                List<Account> accountList = accountService.findAll(currentId);

                for (Account account : accountList) {

                    Object[] row = {account.getId(), account.getType(), account.getSum()};

                    customerView.getModel().addRow(row);
                }


            } catch (EntityNotFoundException e1) {
                e1.printStackTrace();
            }

            generateAction("Searched for customer");

        }
    }

    private class UpdateAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {



            int row = customerView.getTable().getSelectedRow();

            Long id = (long) Integer.parseInt((customerView.getTable().getValueAt(row, 0)).toString());
            int sum = Integer.parseInt(customerView.getTable().getValueAt(row, 2).toString());

            if (accountService.update(id, sum)) {
                JOptionPane.showMessageDialog(customerView,"Update successful");
            }
            else {
                JOptionPane.showMessageDialog(customerView,"Error while trying to update");
            }

            generateAction("Updated account information");
        }
    }

    private class UpdateCustomerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String customerName = customerView.getNameText();

            try {

                Customer customer = customerService.findById(currentId);

                String identityCardText = customerView.getIdentityCardText();
                String persNumCodeText = customerView.getPersNumCodeText();

                Customer customer1 = new CustomerBuilder().setId(customer.getId()).setName(customerName).setIdentityCard(identityCardText).setPersNumCode(persNumCodeText).build();

                if (customerService.update(customer1)) {
                    JOptionPane.showMessageDialog(customerView,"Customer info updated successfully!");
                }
                else {
                    JOptionPane.showMessageDialog(customerView,"Fail to update the customer");
                }
            } catch (EntityNotFoundException e1) {
                e1.printStackTrace();
            }

            generateAction("Updated customer information");
        }
    }

    private class SpendingAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            customerView.setSumTextAvailable();
        }
    }

    private class SavingAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            customerView.setSumTextUnavailable();
        }
    }

    private void generateAction(String actionDetails) {

        System.out.println("username " + loginView.getUsernameText());
        Long idForAction = userService.findIdByUsername(loginView.getUsernameText());

        Action action = new ActionBuilder()
                .setDate(new Date(System.currentTimeMillis()))
                .setDetails(actionDetails)
                .setEmployeeId(idForAction)
                .build();

        actionService.save(action);
    }
}
