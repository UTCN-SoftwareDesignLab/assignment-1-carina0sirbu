package model;

import java.util.List;

public class Customer {

    private Long id;
    private String name;
    private String identityCard;
    private String persNumCode;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard1) {
        this.identityCard = identityCard1;
    }

    public String getPersNumCode() {
        return persNumCode;
    }

    public void setPersNumCode(String persNumCode) {
        this.persNumCode = persNumCode;
    }

    @Override
    public String toString() {
        return "Customer id " + id + ", " + name + ", with IDCard no " + identityCard + " and PNC no " + persNumCode;
    }
}
