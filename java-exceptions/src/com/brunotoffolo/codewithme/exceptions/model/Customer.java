package com.brunotoffolo.codewithme.exceptions.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Represents a customer. Contains only minimal information to make this
 * example concise and clean, allowing us to get straight to the point in
 * what we want to demonstrate.
 *
 * @author Bruno Toffolo
 */
public class Customer {

    private Account account;
    private final String cpf;
    private String firstName;
    private String lastName;
    private final Calendar creationDate;

    public Customer(String cpf, String firstName, String lastName) {
        this.cpf = cpf;
        this.firstName = firstName;
        this.lastName = lastName;
        this.creationDate = new GregorianCalendar();
    }

    /**
     * Gets the bank account related to the customer
     * @return Account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Sets the bank account related to the customer.
     * @param account Account to be set
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Gets the customer's CPF
     * @return Last name
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Gets the customer's first name
     * @return First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the customer's last name
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Customer " + getFirstName() + " " + getLastName() + ", CPF " + getCpf();
    }
}
