package com.brunotoffolo.codewithme.exceptions.model;

import java.util.Calendar;
import java.util.Collections;
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

        // Now we have initialized the credit cards list with an empty list from the
        // Collections library. This returns a list with no elements, but does not
        // yet solve all of our problems. Check the ExceptionHandlingScenario class
        // to read more about it.
        this.creditCards = Collections.emptyList();
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

        // The NullPointerException is gone as the list is already initialized with the
        // Collections.emptyList() call in the constructor on line 40. However, there is
        // still a problem with that! As it is immutable, we can not add any new objects
        // to this list -- otherwise, an UnsupportedOperationException is thrown.
        // In the next commit, we will initialize the list with a new list that will be
        // manually created. This will solve the problem for good and allow us to insert
        // a new credit card in the list, as desired.

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
