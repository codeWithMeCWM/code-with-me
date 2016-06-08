package com.brunotoffolo.codewithme.exceptions.model;

import com.brunotoffolo.codewithme.exceptions.exception.InsufficientFundsException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
    public double addPurchase(double amount, String description) throws InsufficientFundsException {
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

    /**
     * Generates a simple invoice file for the credit card and saves it into a file. The
     * invoice is a plain text file containing information of the card, the purchases and
     * total balance at the present time.
     *
     * @param filename Name of the file in which the invoice should be stored.
     */
    public void createInvoice(String filename) {

        // In this method, we are going to create a new file containing the invoice. To
        // create a simple text file in a Java program, we need to instantiate a new
        // BufferedWriter that will be used to write the information we want into a file.
        // This BufferedWriter takes a FileWriter as a parameter, and the latter needs a
        // File object to be created.

        // That said, let's create the variables and write the invoice information into
        // our file. We will also create a SimpleDateFormat object to export the purchase
        // dates in a specific format.

        File invoiceFile = new File(filename);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy, HH:MM");
        String currentTime = dateTimeFormat.format(Calendar.getInstance().getTime());

        // As BufferedWriter's write() method may throw an IOException when invoked, we
        // need to wrap the calls in a try/catch block. Moreover, as this class consumes
        // system resources, we need to close it as soon as we are done using it.

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(invoiceFile));
            bufferedWriter.write("INVOICE FOR: " + brand + " " + number + "\r\n");
            bufferedWriter.write("--------------------------------------------\r\n");
            bufferedWriter.write("PURCHASES\r\n");
            bufferedWriter.write("Date\t\tAmount\tDescription\r\n");
            for (Purchase purchase : purchases) {
                bufferedWriter.write(
                        dateFormat.format(purchase.getDate().getTime()) + "\t" +
                        purchase.getAmount() + "\t" +
                        purchase.getDescription() + "\r\n");
            }
            bufferedWriter.write("--------------------------------------------\r\n");
            bufferedWriter.write("TOTAL AMOUNT: USD " + balance + "\n");
            bufferedWriter.write("Remaining limit: USD " + (limit - balance) + "\n");
            bufferedWriter.write("--------------------------------------------\r\n");
            bufferedWriter.write("Invoice generated at " + currentTime);

            System.out.println("CC " + number + " | Invoice generated in " + filename);
        } catch (IOException e) {
            System.err.println("Error while exporting credit card invoice: " + e.getMessage());
        } finally {
            // The 'finally' block had not been presented here yet. It may be used after
            // a try or a catch block and represents operations that need to be performed
            // independently of the exception having been thrown or not.

            // This block is ensured by the JVM to run after the needed operations in the
            // try/catch block have been executed. That is a reason why the finally block
            // is usually reserved for doing clean-up activities such as, in our case,
            // closing the opened resources (to guarantee that all reserved system resources
            // will be freed after we finished using them).

            // As the close() method of BufferedWriter may also throw an IOException, we
            // should wrap it in a try/catch block. As a best practice, the contents in a
            // finally block should NEVER throw an exception -- because, conceptually, all
            // operations that could throw an exception have already been performed in the
            // try block.

            try {
                bufferedWriter.close();
            } catch (IOException e) {
                System.err.println("Error while closing invoice BufferedWriter: " + e.getMessage());
            } catch (NullPointerException e) {
                // As we had not initialized the BufferedWriter before the try block begins,
                // it is possible that the variable is still null when we try to invoke the
                // close() method.
                System.err.println("Error while closing invoice BufferedWriter: " + e.getMessage());
            }
        }
    }

}
