package model.builder;

import model.Account;
import java.util.Date;

public class AccountBuilder {

    private Account account;

    public AccountBuilder() {

        account = new Account();
    }

    public AccountBuilder setType(String type) {
        account.setType(type);
        return this;
    }

    public AccountBuilder setSum (int sum) {
        account.setSum(sum);
        return this;
    }

    public AccountBuilder setCreationDate(Date date) {
        account.setCreationDate(date);
        return this;
    }

    public Account build() {
        return account;
    }
}
