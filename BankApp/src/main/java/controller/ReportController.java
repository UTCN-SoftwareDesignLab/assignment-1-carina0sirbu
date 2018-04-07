package controller;

import view.ReportView;


public class ReportController implements ControllerFeature {

    private ReportView reportView;

    public ReportController (ReportView reportView) {

        this.reportView = reportView;

    }

    @Override
    public void setViewVisible() {
        reportView.setVisible(true);
    }

    public void setReportView(String actionName) {
        reportView.setTxtReport(actionName);
    }

    public void setEmployeeName(String name) {
        reportView.setEmployeeNameText(name);
    }

    public String getReportText() {
        return reportView.getTxtReport();
    }
}
