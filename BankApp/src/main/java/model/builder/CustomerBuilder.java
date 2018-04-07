package model.builder;

import model.Customer;

public class CustomerBuilder {

    private Customer customer;

    public CustomerBuilder() {
        customer = new Customer();
    }

    public CustomerBuilder setId(Long id) {
        customer.setId(id);
        return this;
    }

    public CustomerBuilder setName(String name) {
        customer.setName(name);
        return this;
    }

    public CustomerBuilder setIdentityCard(String identityCard) {
        customer.setIdentityCard(identityCard);
        return this;
    }

    public CustomerBuilder setPersNumCode(String persNumCode) {
        customer.setPersNumCode(persNumCode);
        return this;
    }

    public Customer build() {
        return customer;
    }
}
