package controller;

import model.Action;
import model.User;
import service.action.ActionServiceImpl;

import service.user.UserServiceImpl;
import view.AdminView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdminController implements ControllerFeature {

    private final AdminView adminView;
    private final ReportController reportController;
    private final UserServiceImpl userService;
    private final ActionServiceImpl actionService;

    public AdminController(AdminView adminView, ReportController reportController, UserServiceImpl userService, ActionServiceImpl actionService) {

        this.adminView = adminView;
        this.reportController = reportController;
        this.userService = userService;
        this.actionService = actionService;

        adminView.setBtnDeleteEmployeeListener(new DeleteEmployeeListener());
        adminView.setBtnUpdateEmployeeListener(new UpdateEmployeeListener());
        adminView.setBtnGenerateReportsListener(new GenerateReportListener());
        adminView.setBtnShowEmployeeListener(new ShowEmployeeListener());
    }

    @Override
    public void setViewVisible() {

        adminView.setVisible(true);
    }

    private class DeleteEmployeeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            int row = adminView.getTable().getSelectedRow();

            Long id = (long) Integer.parseInt((adminView.getTable().getValueAt(row, 0)).toString());

            if (userService.delete(id)) {
                JOptionPane.showMessageDialog(adminView,"User deleted!");
            }
            else {
                JOptionPane.showMessageDialog(adminView,"Error while trying to delete");
            }

            ((DefaultTableModel)adminView.getTable().getModel()).removeRow(row);
        }
    }

    private class UpdateEmployeeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            int row = adminView.getTable().getSelectedRow();

            Long id = (long) Integer.parseInt((adminView.getTable().getValueAt(row, 0)).toString());
            String username = adminView.getTable().getValueAt(row, 1).toString();

            if (userService.update(id, username)) {
                JOptionPane.showMessageDialog(adminView,"Update successful");
            }
            else {
                JOptionPane.showMessageDialog(adminView,"Error while trying to update");
            }


        }
    }

    private class GenerateReportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


            reportController.setViewVisible();
            reportController.setReportView("");

            DateFormat formatter = new SimpleDateFormat("yy-MM-dd");

            try {
                Date startingDate = formatter.parse(adminView.getStartingDate());
                Date endingDate = formatter.parse(adminView.getEndingDate());

                String username = adminView.getTable().getValueAt(adminView.getTable().getSelectedRow(), 1).toString();

                List<Action> actions = actionService.getActionsByEmployeeId((long) Integer.parseInt(adminView.getTable().getValueAt(adminView.getTable().getSelectedRow(), 0).toString()));

                for (Action action: actions) {
                    if(action.getDate().after(startingDate) && action.getDate().before(endingDate))
                        reportController.setReportView(reportController.getReportText() + action + "\n");
                }

                reportController.setEmployeeName(username);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
    }

    private class ShowEmployeeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


            List<User> users = userService.findAll();

            for (User user: users) {

                Object[] row = {user.getId(), user.getUsername()};

                adminView.getModel().addRow(row);
            }
        }
    }
}
