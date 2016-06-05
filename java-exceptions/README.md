# Exceptions in Java

This is just a simple project used to demonstrate how exception handling can be
performed in Java. It was originally presented in a knowledge transfer session
regarding Java exceptions. The code is filled with some comments to demonstrate
some best practices and problems that can happen by using some coding strategies
when implementing business logic.

History is important in this Git repo, as it follows an incremental strategy to
demonstrate concepts and presente information throughout the code. By following
the order of commits it is possible to see how exceptions may be handled in a
Java application. Some potential pitfalls are also fixed in the commit history
to show how they can be handled and avoided in a real-world application.


## Contextualization

This code was presented in a session focused on providing some context on how to
work with exceptions in Java. A short story can be told to explain the execution
flow:

> John Doe has just changed his job and hence created a new bank account where
> he would receive his earnings. His first salary was credited in the same week
> as his anniversary with his spouse, so he decided to buy her some gifts to
> make it an even more special moment. After that, he tried to book a short
> weekend trip so they could celebrate it, but he didn't have enough credit
> limit on his card to buy all that. He then decides to print his credit card's
> invoice to check what was going on and called the hotel to cancel his
> reservation as they were not going anymore.

The order of method calls can be seen as a Java implementation of this short
story. To make it easier to follow the steps and understand the concepts, this
repository will have many commits containing small changes. The reason for these
changes will be briefly explained in the commit messages and inside the code,
with some auxiliary comments.

The classes were divided in logical packages regarding their purposes in the app
(models, business logic and custom exceptions).


## How to run the code

To keep the repository concise and clean, IDE-specific files were not commited.
As this is a simple application, just clone the repository and run the
`ExceptionHandlingScenario.java` as it contains the `main()` method. Some detailed
tutorials on how to do that are available for
[IntelliJ IDEA](https://www.jetbrains.com/help/idea/2016.1/running-applications.html),
[NetBeans](https://netbeans.org/kb/docs/java/quickstart.html#run) and
[Eclipse](http://stackoverflow.com/a/12546688/3227787).

Log messages were inserted in the code, through simple `System.out` messages, to
make it easier to follow the order in which the commands were invoked by simply
examining the console output after the application is run.