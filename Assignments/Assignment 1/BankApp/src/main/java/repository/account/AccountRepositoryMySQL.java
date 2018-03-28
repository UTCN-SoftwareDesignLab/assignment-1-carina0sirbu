package repository.account;

import model.Account;
import model.Customer;
import model.builder.AccountBuilder;
import repository.EntityNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryMySQL implements AccountRepository{

    private final Connection connection;

    public AccountRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List<Account> findAll(Customer customer) {
        List<Account> accounts = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String sql = "Select * from account where name like %" + customer.getName() + "%";
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
    public boolean save(Customer customer, Account account) {

        try {
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT INTO account values (null, ?, ?, ?)");
            insertStatement.setString(1, account.getType());
            insertStatement.setString(2, String.valueOf(account.getSum()));
            insertStatement.setDate(3, new java.sql.Date(account.getCreationDate().getTime()));
            insertStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Customer customer, Account account) {



        return false;
    }

    @Override
    public boolean update(Customer customer, Account account) {
        return false;
    }

    private Account getAccountFromResultSet(ResultSet rs) throws SQLException {
        return new AccountBuilder()
                .setType(rs.getString("type"))
                .setCreationDate(rs.getDate("creation_date"))
                .setSum(rs.getInt("sum"))
                .build();
    }
}
