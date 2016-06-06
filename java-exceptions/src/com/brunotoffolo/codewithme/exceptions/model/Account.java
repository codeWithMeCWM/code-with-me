package com.brunotoffolo.codewithme.exceptions.model;

import java.util.*;

/**
 * Basic and generic bank account to serve as an example for the banking scenario.
 *
 * An account contains only the essential information to allow credit card usage and
 * a customer to have a bank account. As the scope of this example does not make any
 * distinction between checking and savings accounts, we consider them to be the same
 * "account" entity.
 *
 * @author Bruno Toffolo
 */
public class Account {

    private final int number;
    private double balance;
    private double creditLimit;
    private final Calendar creationDate;
    private final Customer customer;
    private List<CreditCard> creditCards;

    public Account(int number, Customer customer) {
        // This is a basic constructor used to initialize the fields and assign an
        // initial credit limit for the customer.
        this.number = number;
        this.balance = 0.0;
        this.customer = customer;
        this.creationDate = new GregorianCalendar();
        this.creditLimit = 2000.00;

        // By manually creating a list to hold the credit cards, we can ensure that
        // it will not be null when we need it and that no exception will be thrown
        // when we try to update it.
        this.creditCards = new ArrayList<>();
    }

    /**
     * Deposits a given amount in the account.
     *
     * @param value Value to be deposited.
     * @return true if deposit was successful; false otherwise
     */
    public boolean deposit(double value) {
        // Note that we just check if the value is positive, but do not provide any message
        // to the client application to give some context if the deposit is not concluded.
        // We will be able to do it using exceptions -- the next commits will contain some
        // detail on that.
        if (value > 0) {
            balance += value;
            System.out.println("Account " + number + " | Deposited value: USD " + value + " | New balance: USD " + balance);
            return true;
        }

        return false;
    }

    /**
     * Withdraws a given amount from the account.
     *
     * @param value Value to be withdrawn.
     * @return true if withdrawal was successful; false otherwise
     */
    public boolean withdraw(double value) {
        // Here we also make the check but don't provide any additional detail for the
        // error cases. It will be fixed soon.
        if ( (value > 0) && (value < (balance + creditLimit)) ){
            balance -= value;
            System.out.println("Account " + number + " | Withdrawn value: USD " + value +
                    " | Remaining balance: USD " + balance);
            return true;
        }

        return false;
    }

    /**
     * Adds a new credit card to the account.
     *
     * @param card Card to be added
     * @return true if addition was successful; false otherwise
     */
    public boolean addCreditCard(CreditCard card) {
        // As we have manually created a new list in the constructor, this
        // method will run without throwing an exception anymore.
        return creditCards.add(card);
    }

    /**
     * Gets the list of account credit cards.
     *
     * @return List of cards
     */
    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    /**
     * Gets the account number.
     *
     * @return Account number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Gets the account balance.
     *
     * @return Account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets the account credit limit.
     *
     * @return Credit limit
     */
    public double getCreditLimit() {
        return creditLimit;
    }

    /**
     * Sets the account credit limit.
     *
     * @param creditLimit Limit to be set
     */
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * Gets the account creation date.
     *
     * @return Creation date
     */
    public Calendar getCreationDate() {
        return creationDate;
    }

    /**
     * Gets the customer related to this account.
     *
     * @return Customer
     */
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Account number " + number + ", balance of USD " + balance;
    }

}
