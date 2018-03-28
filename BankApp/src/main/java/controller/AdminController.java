package controller;

import view.AdminView;

public class AdminController implements ControllerFeature {

    private final AdminView adminView;


    public AdminController(AdminView adminView) {


        this.adminView = adminView;
    }

    @Override
    public void setViewVisible() {

        adminView.setVisible(true);
    }
}
