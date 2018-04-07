package model.builder;

import model.Action;

import java.util.Date;

public class ActionBuilder {

    private Action action;

    public ActionBuilder() {
        this.action = new Action();
    }

    public ActionBuilder setId(Long id) {
        action.setId(id);
        return this;
    }

    public ActionBuilder setDate(Date date) {
        action.setDate(date);
        return this;
    }

    public ActionBuilder setDetails(String details) {
        action.setDetails(details);
        return this;
    }

    public ActionBuilder setEmployeeId(Long employeeId) {
        action.setEmployeeId(employeeId);
        return this;
    }

    public Action build() {
        return action;
    }
}
