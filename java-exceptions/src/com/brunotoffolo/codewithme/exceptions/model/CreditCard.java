package com.brunotoffolo.codewithme.exceptions.model;

import java.util.ArrayList;
import java.util.Calendar;
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
     * @return true if purchase was correctly processed; false otherwise
     */
    public boolean addPurchase(double amount, String description) {

        // Note that we check if the card's limit is still suitable to accomodate the new
        // purchase and inform the user if the purchase could be completed or not, but there
        // is not any additional information provided in the case where it is not possible
        // complete the purchase.
        //
        // This could be better handled with an exception to provide some context and an error
        // message. We will do that soon.

        if (balance + amount < limit) {
            balance += amount;

            Purchase purchase = new Purchase(amount, description);
            purchases.add(purchase);

            System.out.println("CC " + number + " | New purchase: USD " + amount +
                    " | Current balance: USD " + balance);
            return true;
        }

        return false;
    }

}
