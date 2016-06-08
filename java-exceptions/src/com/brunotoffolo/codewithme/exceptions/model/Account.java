package com.brunotoffolo.codewithme.exceptions.model;

import com.brunotoffolo.codewithme.exceptions.exception.InsufficientFundsException;

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

    /**
     * Basic constructor used to initialize the account and provide an initial
     * credit limit for the customer.
     * @param number Account number
     * @param customer Customer the account belongs to
     */
    public Account(int number, Customer customer) {
        this.number = number;
        this.balance = 0.0;
        this.customer = customer;
        this.creationDate = new GregorianCalendar();
        this.creditLimit = 2000.00;
        this.creditCards = new ArrayList<>();
    }

    /**
     * Deposits a given amount in the account.
     *
     * @param value Value to be deposited.
     * @return Updated balance after deposit was performed
     */
    public double deposit(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Deposited value should be higher than zero");
        }

        balance += value;
        System.out.println("Account " + number + " | Deposited value: USD " + value + " | New balance: USD " + balance);
        return balance;
    }

    /**
     * Withdraws a given amount from the account.
     *
     * @param value Value to be withdrawn.
     * @return Updated balance after withdrawal was performed
     */
    public double withdraw(double value) throws InsufficientFundsException {
        if (value < 0) {
            throw new IllegalArgumentException("Withdrawal value should be higher than zero");
        }

        // As we throw our custom exception inside the if block, and this exception is now a
        // checked exception, the Java compiler requires us to update the method signature
        // informing that it can throw it when invoked. Note that 'throws InsufficientFundsException'
        // has been added to the end of the method signature.
        if (value > (balance + creditLimit)) {
            throw new InsufficientFundsException("Desired amount is higher than available amount");
        }

        balance -= value;
        System.out.println("Account " + number + " | Withdrawn value: USD " + value +
                " | Remaining balance: USD " + balance);
        return balance;
    }

    /**
     * Adds a new credit card to the account.
     *
     * @param card Card to be added
     * @return true if addition was successful; false otherwise
     */
    public boolean addCreditCard(CreditCard card) {
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
        if (creditLimit < 0) {
            throw new IllegalArgumentException("Account credit limit should be a positive value");
        }

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
