package repository.action;

import model.Action;
import model.builder.ActionBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActionRepositoryMySQL implements ActionRepository {

    private final Connection connection;


    public ActionRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }




    @Override
    public boolean save(Action action) {

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO action values (null, ?, ?, ?)");
            statement.setDate(1, new java.sql.Date(action.getDate().getTime()));
            statement.setString(2, action.getDetails());
            statement.setLong(3, action.getEmployeeId());
            statement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }



    }

    @Override
    public List<Action> getActionsByEmployeeId(Long id) {

        List<Action> actions = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String sql = "Select * from action where employeeId = " + id;
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                actions.add(getAccountFromResultSet(rs));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actions;
    }

    private Action getAccountFromResultSet(ResultSet rs) throws SQLException {
        return new ActionBuilder()
                .setId(rs.getLong("id"))
                .setDate(rs.getDate("date"))
                .setDetails(rs.getString("details"))
                .setEmployeeId(rs.getLong("employeeId"))
                .build();


    }
}
