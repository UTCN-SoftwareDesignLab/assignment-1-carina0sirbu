package repository.account;

import model.Account;
import model.builder.AccountBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryMySQL implements AccountRepository{

    private final Connection connection;


    public AccountRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List<Account> findAll(Long customerId) {

        List<Account> accounts = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String sql = "Select * from account where customerId = " + customerId;
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                accounts.add(getAccountFromResultSet(rs));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Account findById(Long id) {

        Account account = new Account();

        try {
            Statement statement = connection.createStatement();
            String sql = "Select * from account where customerId = " + id;
            ResultSet rs = statement.executeQuery(sql);

            rs.next();
            account = getAccountFromResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }


    @Override
    public boolean save(String customerId, Account account) {

        try {
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT INTO account values (null, ?, ?, ?, ?)");
            insertStatement.setString(1, account.getType());
            insertStatement.setString(2, String.valueOf(account.getSum()));
            insertStatement.setDate(3, new java.sql.Date(account.getCreationDate().getTime()));
            insertStatement.setString(4, customerId);
            insertStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {

        try {
            PreparedStatement insertStatement = connection
                    .prepareStatement("DELETE from account where id = " + id);
            insertStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Long id, int sum) {

        try {
            PreparedStatement updateStatement = connection
                    .prepareStatement("UPDATE account SET " +
                                        "sum = ? WHERE id = " + id);
            updateStatement.setInt(1, sum);

            updateStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Account findByAccountId(Long id) {

        Account account = new Account();

        try {
            Statement statement = connection.createStatement();
            String sql = "Select * from account where id = " + id;
            ResultSet rs = statement.executeQuery(sql);

            rs.next();
            account = getAccountFromResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

    private Account getAccountFromResultSet(ResultSet rs) throws SQLException {
        return new AccountBuilder()
                .setId(rs.getLong("id"))
                .setType(rs.getString("type"))
                .setCreationDate(rs.getDate("creationDate"))
                .setSum(rs.getInt("sum"))
                .setCustomerId(rs.getLong("customerId"))
                .build();


    }


}
