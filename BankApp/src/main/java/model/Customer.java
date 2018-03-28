package model;

import java.util.List;

public class Customer {

    private String name;
    private long identityCard;
    private String persNumCode;
    private List<Account> acc;


    public List<Account> getAcc() {
        return acc;
    }

    public void setAcc(List<Account> acc) {
        this.acc = acc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public long getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(long identityCard1) {
        this.identityCard = identityCard1;
    }

    public String getPersNumCode() {
        return persNumCode;
    }

    public void setPersNumCode(String persNumCode) {
        this.persNumCode = persNumCode;
    }
}
