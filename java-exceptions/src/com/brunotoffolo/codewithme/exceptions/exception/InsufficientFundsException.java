package com.brunotoffolo.codewithme.exceptions.exception;

/**
 * Indicates that the customer does not have enough funds in the account to perform
 * a given operation. As this class extends RuntimeException, it will be created as
 * an unchecked exception.
 *
 * @author Bruno Toffolo
 */
public class InsufficientFundsException extends RuntimeException {

    // Note that this class is a subclass of java.lang.RuntimeException, which means
    // that it will also be a runtime exception and, therefore, unchecked. We can
    // make it a checked exception by changing it into a subclass of the generic
    // java.lang.Exception, but this has additional implications during coding that
    // need to be addressed as well.
    //
    // The next commit will show what are these additional implications for checked
    // exception types and how to handle them in a Java application.

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
