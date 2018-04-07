import controller.*;
import database.DBConnectionFactory;
import repository.account.AccountRepositoryMySQL;
import repository.action.ActionRepositoryMySQL;
import repository.CustomerRepositoryMySQL;
import repository.user.UserRepositoryMySQL;
import service.account.AccountServiceImpl;
import service.action.ActionServiceImpl;
import service.CustomerServiceImpl;
import service.user.UserServiceImpl;
import view.AdminView;
import view.CustomerView;
import view.LoginView;
import view.ReportView;

import java.sql.Connection;

public class Launcher {

    public static void main(String[] args) {
        ComponentFactory componentFactory = ComponentFactory.instance();

        LoginView loginView = new LoginView();

        Connection connection = new DBConnectionFactory().getConnectionWrapper(false).getConnection();

        new LoginController(loginView, componentFactory.getAuthenticationService(),
                            new CustomerController(new CustomerView(), loginView,
                                                    new CustomerServiceImpl(new CustomerRepositoryMySQL(connection)),
                                                    new AccountServiceImpl(new AccountRepositoryMySQL(connection)),
                                                    new ActionServiceImpl(new ActionRepositoryMySQL(connection)),
                                                    new UserServiceImpl(new UserRepositoryMySQL(connection))),
                            new AdminController(new AdminView(),
                                    new ReportController(new ReportView()),
                                                        new UserServiceImpl(new UserRepositoryMySQL(connection)),
                                                        new ActionServiceImpl(new ActionRepositoryMySQL(connection))));
    }
}
