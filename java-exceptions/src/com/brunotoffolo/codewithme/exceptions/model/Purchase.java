package com.brunotoffolo.codewithme.exceptions.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Simple POJO class to represent a purchase.
 *
 * This class was not needed to demonstrate our example scenario, but was
 * created just to make the generated Invoice file a bit more complete.
 *
 * @author Bruno Toffolo
 */
public class Purchase {

    private final Calendar date;
    private final double amount;
    private String description;

    public Purchase(double amount, String description) {
        // Check if purchase amount is valid
        if (amount < 0) {
            throw new IllegalArgumentException("Purchase amount should be higher than zero");
        }

        this.amount = amount;
        this.date = new GregorianCalendar();
        this.setDescription(description);
    }

    /**
     * Gets the purchase date.
     * @return purchase date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * Gets the purchase amount.
     * @return purchase amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the description of the purchase.
     * @return purchase description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the purchase description.
     * @param description New purchase description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
