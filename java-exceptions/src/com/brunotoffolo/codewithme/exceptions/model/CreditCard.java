package com.brunotoffolo.codewithme.exceptions.model;

import com.brunotoffolo.codewithme.exceptions.exception.InsufficientFundsException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Represents a Credit Card. To keep the example short and simple, we only store basic
 * information needed for our desired operations. It could be much more complex in a
 * more detailed example or use case.
 *
 * @author Bruno Toffolo
 */
public class CreditCard {

    private final long number;
    private final String brand;
    private double limit;
    private double balance;
    private final Calendar expirationDate;
    private int pin;
    private List<Purchase> purchases;

    public CreditCard(int pin, Calendar expirationDate, double limit, String brand, long number) {
        if (expirationDate.before(new GregorianCalendar())) {
            throw new IllegalArgumentException("Credit card expiration date should not be in the past");
        }

        this.balance = 0.0;
        this.brand = brand;
        this.expirationDate = expirationDate;
        this.number = number;
        setLimit(limit);
        setPin(pin);
        this.purchases = new ArrayList<>();
    }

    /**
     * Gets the card number.
     *
     * @return Card number
     */
    public long getNumber() {
        return number;
    }

    /**
     * Gets the card limit.
     *
     * @return Card limit
     */
    public double getLimit() {
        return limit;
    }

    /**
     * Sets the card limit.
     *
     * @param limit Limit to be set
     */
    public void setLimit(double limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Credit card limit should be a positive value");
        }

        this.limit = limit;
    }

    /**
     * Gets the card balance.
     *
     * @return Card balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets the card PIN code.
     *
     * @return PIN code
     */
    public int getPin() {
        return pin;
    }

    /**
     * Sets the card PIN code.
     *
     * @param pin Code to be set
     */
    public void setPin(int pin) {
        if (pin < 100000 || pin > 999999) {
            throw new IllegalArgumentException("PIN code must have exactly six digits");
        }

        this.pin = pin;
    }

    /**
     * Gets the card brand.
     *
     * @return Card brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Gets the card expiration date.
     *
     * @return Expiration date
     */
    public Calendar getExpirationDate() {
        return expirationDate;
    }

    /**
     * Adds a new purchase in the credit card invoice.
     *
     * @param amount Amount of the purchase.
     * @param description Description of the purchase.
     * @returns Partial balance including the added purchase
     */
    public double addPurchase(double amount, String description) {

        // Now that this method does already throw an exception if the the purchase amount exceeds
        // the currently available limit for the credit card, we can change it from an "illegal
        // argument" to an "insufficient funds" type. This will provide an even better context for
        // the application developer to debug the code and find out what the problem is when a
        // purchase can not be completed.

        if (balance + amount > limit) {
            throw new InsufficientFundsException("Purchase amount is higher than the available limit");
        }

        balance += amount;

        Purchase purchase = new Purchase(amount, description);
        purchases.add(purchase);

        System.out.println("CC " + number + " | New purchase: USD " + amount +
                " | Current balance: USD " + balance);

        return balance;
    }

}
