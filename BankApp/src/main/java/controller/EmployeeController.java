package controller;

import view.EmployeeView;

public class EmployeeController implements ControllerFeature {

    private final EmployeeView employeeView;

    public EmployeeController(EmployeeView employeeView) {

        this.employeeView = employeeView;
    }

    @Override
    public void setViewVisible() {
        employeeView.setVisible(true);
    }
}
