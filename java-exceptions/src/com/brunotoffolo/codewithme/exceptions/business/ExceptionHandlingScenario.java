package com.brunotoffolo.codewithme.exceptions.business;

import com.brunotoffolo.codewithme.exceptions.model.Account;
import com.brunotoffolo.codewithme.exceptions.model.CreditCard;
import com.brunotoffolo.codewithme.exceptions.model.Customer;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 * Test application to demonstrate the usage of exceptions in a real-world code.
 *
 * As the only purpose of this app is to demonstrate how to use exceptions and it
 * will not be extended into a bigger or more complex software, we will use only
 * static variables to allow our code to be as simple as possible.
 *
 * @author Bruno Toffolo
 */
public class ExceptionHandlingScenario {

    /** Main account used in the example scenario. */
    private static Account account;

    /** Customer used in the example scenario. */
    private static Customer customer;

    /** Used internally to generate random numbers. */
    private static final Random random = new Random();

    /**
     * Main application. It contains some execution flow and comments to demonstrate
     * how exception handling can be done in a Java application.
     *
     * @param args Arguments passed to the program.
     */
    public static void main(String[] args) {

        // John Doe started a new job, so let's create a new bank account for him.
        initializeCustomerAndAccount();

        // He also earned his salary, so let's deposit it into his new account.
        account.deposit(2500.00);

        // He needed to buy some groceries on his way home, so he decided to check
        // how many different cards his new account provides. He can pick one of them
        // to pay the market.
        List<CreditCard> creditCards = account.getCreditCards();
        int numberOfCreditCards = creditCards.size();

        // Let's check if there is any card available. If the account does not provide
        // one by default, let's order it!
        CreditCard creditCard;
        if (numberOfCreditCards == 0) {
            creditCard = createCreditCard("Visa");
            account.addCreditCard(creditCard);
        } else {
            creditCard = creditCards.get(0);
        }

        // John's new credit card has arrived! Let's set a new PIN so he can start using it.
        try {
            creditCard.setPin(1000 + random.nextInt(9000));
        } catch (IllegalArgumentException e) {
            creditCard.setPin(100000 + random.nextInt(900000));
        }

        // We have presented above the classic and simplest approach to handling exceptions
        // in Java: using a try/catch block. Any operation that may throw an exception should
        // be placed in the 'try' block, while the operations that should be performed in case
        // the exception happens should be placed in the 'catch' block.

        // In the next commit, we will create our own custom exception, to indicate that the
        // customer does not have enough funds to perform a specific operation. Check the next
        // commit to discover how we can do it.
    }

    /**
     * Initialize variables by creating a new customer and an account for him.
     * This sets up John's account so he can start using it to earn and spend some
     * money.
     */
    private static void initializeCustomerAndAccount() {
        customer = new Customer("987.654.321-00", "John", "Doe");

        // Generate a new random account number
        int accountNumber = 1000000 + random.nextInt(9000000);
        account = new Account(accountNumber, customer);

        System.out.println(customer);
        System.out.println(account);
    }

    /**
     * Creates a credit card from a given brand.
     *
     * @param brand Card's brand
     * @return Credit card object
     */
    private static CreditCard createCreditCard(String brand) {
        // Creates a random six-digit PIN code and 16-digit credit card number
        int pin = (int) (100000 + 900000 * Math.random());
        long number = 1000000000000000L + (long) (random.nextDouble() * 9000000000000000L);
        GregorianCalendar expirationDate = new GregorianCalendar(2025, 10, 01);

        CreditCard card = new CreditCard(pin, expirationDate, 5000, brand, number);
        System.out.println("Credit card number " + number + " created with a USD 5000.00 limit");

        return card;
    }
}
