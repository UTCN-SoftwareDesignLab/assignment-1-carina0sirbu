import controller.*;
import view.AdminView;
import view.EmployeeView;
import view.LoginView;
import view.StartView;

public class Launcher {

    public static void main(String[] args) {
        ComponentFactory componentFactory = ComponentFactory.instance();

        new StartController(new StartView(),
                            new LoginController(new LoginView(), componentFactory.getAuthenticationService()),
                            new EmployeeController(new EmployeeView()),
                            new AdminController(new AdminView()));
    }
}
