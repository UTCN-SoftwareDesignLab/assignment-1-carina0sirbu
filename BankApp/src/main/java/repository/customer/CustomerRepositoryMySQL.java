package repository.customer;

import model.Account;
import model.Customer;
import model.builder.CustomerBuilder;
import repository.EntityNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryMySQL implements  CustomerRepository {

    private final Connection connection;

    public CustomerRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Customer> findAll() {

        List<Customer> customers = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String sql = "Select * from customer";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    @Override
    public Customer findById(Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public boolean save(Customer customer) {

        try {
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT INTO customer values (null, ?, ? ?)");
            insertStatement.setString(1, customer.getName());
            insertStatement.setLong(2, customer.getIdentityCard());
            insertStatement.setString(3, customer.getPersNumCode());
            insertStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void removeAll() {

        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE from customer where id >= 0";
            statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Customer getCustomerFromResultSet(ResultSet rs) throws SQLException {
        return new CustomerBuilder()
                .setName(rs.getString("name"))
                .setIdentityCard(rs.getLong("identityCard"))
                .setPersNumCode(rs.getString("persNumCode"))
                .build();
    }
}
