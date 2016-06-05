package com.brunotoffolo.codewithme.exceptions.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

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

        // Note that the credit cards list is not initialized here. It was on purpose
        // to demonstrate which impacts it may have during the application execution.
        // It will be fixed along the next commits.
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

        // Here we will face a NullPointerException when we try to add a new credit card.
        // As we didn't initialize the list in the constructor, the variable still points
        // to a null object, what will raise an exception when we try to invoke the add()
        // method on it.
        // In the next commit, we will initialize the list with a special empty list. The
        // null pointer error will be gone, but new problems may arise...

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
