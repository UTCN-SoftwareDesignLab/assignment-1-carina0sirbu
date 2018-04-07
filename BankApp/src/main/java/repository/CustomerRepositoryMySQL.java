package repository;

import model.Customer;
import model.builder.CustomerBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryMySQL implements CustomerRepository {

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

                customers.add(getCustomerFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    @Override
    public Customer findById(String name) throws EntityNotFoundException {

        Customer customer = new Customer();

        try {
            Statement statement = connection.createStatement();
            String sql = "Select * from customer WHERE name like '" + name + "'";


            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                customer = getCustomerFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer findById(Long id) throws EntityNotFoundException {

        Customer customer = new Customer();
        try {
            Statement statement = connection.createStatement();
            String sql = "Select * from customer WHERE id = " + id + "";
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                customer = getCustomerFromResultSet(rs);

            }
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean save(Customer customer) {

        try {
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT INTO customer values (null, ?, ?, ?)");
            insertStatement.setString(1, customer.getName());
            insertStatement.setString(2, customer.getIdentityCard());
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

    public boolean delete(Long id) {

        try {
            Statement deleteStatement = connection.createStatement();
            String sql = "DELETE from customer where id = " + id;
            deleteStatement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Customer customer) {

        try {
            PreparedStatement updateStatement = connection
                    .prepareStatement("UPDATE customer SET " +
                            "name = ?, " +
                            "identityCard = ?, " +
                            "persNumCode = ? WHERE id = " + customer.getId());


            updateStatement.setString(1, customer.getName());
            updateStatement.setString(2, customer.getIdentityCard());
            updateStatement.setString(3, customer.getPersNumCode());

            updateStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Customer getCustomerFromResultSet(ResultSet rs) throws SQLException {

        return new CustomerBuilder()
                .setId(rs.getLong("id"))
                .setName(rs.getString("name"))
                .setIdentityCard(rs.getString("identityCard"))
                .setPersNumCode(rs.getString("persNumCode"))
                .build();
    }
}
