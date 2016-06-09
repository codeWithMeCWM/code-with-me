package com.brunotoffolo.codewithme.exceptions.business;

import com.brunotoffolo.codewithme.exceptions.exception.InsufficientFundsException;
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

        // As he does already have a card, he can go to an ATM and get some money for the
        // daily expenses. Let's take enough to pay the rent and buy the groceries, and
        // an additional amount to buy his wife some nice gifts to celebrate the anniversary.
        try {
            account.withdraw(3500.00);
            account.withdraw(1200.00);
        } catch (InsufficientFundsException e) {

            // If John's credit limit is not enough to perform the withdrawal, he will make
            // the payments using his credit card. In this case, let's add the purchases to
            // his invoice.

            // As adding a purchase can also throw an exception due to insufficient funds, we
            // also need to wrap it inside a try/catch block. It is possible to nest these
            // blocks as deep as desired.
            try {
                creditCard.addPurchase(699.00, "Gold ring");
                creditCard.addPurchase(89.50, "Wine bottle");
            } catch (InsufficientFundsException ex) {
                // If he does not have enough money for the gifts, the anniversary celebration
                // is over. Let's just log the error and that's it...
                System.err.println("Anniversary gifts can not be purchased: " + ex.getMessage());
            }
        }

        // Now that the groceries and gifts are already bought, John decides to plan a
        // getaway on the weekend to a resort close to the beach and celebrate the anniversary
        try {
            creditCard.addPurchase(1497.00, "Air tickets");
            creditCard.addPurchase(2399.00, "Hotel reservation");
            creditCard.addPurchase(359.00, "Sightseeing tour pack");
        } catch (InsufficientFundsException e) {
            // If we are in the catch block, it means that something went wrong and John could
            // not make one or more of his reservations for the weekend trip. To check what's
            // wrong, he decides to print his credit card invoices and see his recent purchases.
            creditCard.createInvoice("invoice_" + creditCard.getNumber() + ".txt");
        }

        // In the last commit we implemented a new method that generates the invoice for a given
        // credit card and save that in a file. In the code we were able to demonstrate how to
        // use the finally block when handling exceptions and also give another real world case
        // of exception handling.

        // At this time, we added a small change in the way we handle multiple exceptions. The
        // main purpose of this commit was to demonstrate how we are able to adopt a single
        // strategy when handling different exception types. By using a vertical bar, that is
        // represented by the symbol '|', we are able to catch multiple exceptions in a single
        // catch block. You can see it in the CreditCard class.

        // The main purpose of this enhancement, that was introduced in Java SE 7, is to reduce
        // code duplication and avoid catching a broader exception instead of multiple more
        // specific ones.
        // More details about this feature can be found in the Java SE 7 Documentation page at
        // http://docs.oracle.com/javase/7/docs/technotes/guides/language/catch-multiple.html .
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
