package com.brunotoffolo.codewithme.exceptions.business;

import com.brunotoffolo.codewithme.exceptions.model.Account;
import com.brunotoffolo.codewithme.exceptions.model.CreditCard;
import com.brunotoffolo.codewithme.exceptions.model.Customer;

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

        // Ops! What happened here?
        //
        // We got a NullPointerException because the credit cards list was not correctly
        // initialized in the Account class. This is an exception thrown by the JVM to tell
        // the programmer that he/she tried to dereference a variable that was not yet
        // assigned to a valid memory block (i.e. null).
        //
        // To prevent such exception from happening in our code, we need to ensure that this
        // variable is not null before invoking a method on it. We can explicitly add a check
        // (using an 'if' statement) or initialize the list in the Account class.
        //
        // The latter is clearly a more suitable option, so let's do it on the next commit.
        // It will also contain some other validations and exceptions being thrown in the
        // classes constructors and methods, to show how we can handle it in real-world Java
        // applications.
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
}
