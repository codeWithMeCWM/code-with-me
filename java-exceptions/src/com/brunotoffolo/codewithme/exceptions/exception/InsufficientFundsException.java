package com.brunotoffolo.codewithme.exceptions.exception;

import java.lang.Exception;

/**
 * Indicates that the customer does not have enough funds in the account to perform
 * a given operation. As this class extends RuntimeException, it will be created as
 * an unchecked exception.
 *
 * @author Bruno Toffolo
 */
public class InsufficientFundsException extends Exception {

    // By changing the super class of this exception from java.lang.RuntimeException
    // to java.lang.Exception, it becomes a compile time exception (also called a
    // checked exception).
    //
    // With this change, the Java compiler (and also the Java IDEs) are aware of this
    // exception and will require explicit handling in any code invoking a method that
    // is able to throw it at runtime.
    //
    // Browse the code to check what needed to be changed due to this new information.
    // You can find changes in the Account, CreditCard and ExceptionHandlingScenario
    // classes of our application.

    /**
     * Creates a new exception with the given message.
     *
     * @param message The error message.
     * @see Exception#Exception(String)
     */
    public InsufficientFundsException(String message) {
        super(message);
    }

    /**
     * Creates a new exception with the given cause and the default message for this
     * cause, obtained by cause.toString().
     *
     * @param cause The exception cause.
     * @see Exception#Exception(Throwable)
     */
    public InsufficientFundsException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new exception with the given message and cause.
     *
     * @param message The error message.
     * @param cause The exception cause.
     * @see Exception#Exception(String, Throwable)
     */
    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }

}
