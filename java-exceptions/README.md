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


## Step-by-step commit list

As the main purpose of this project is to provide an interactive tutorial of exception
handling in Java, it was conceived as an incremental version of our initial code. Each
new commit added to the repo performed a significant change that could show a new best
practice in exception handling.

The best way to make the most out of this tutorial is to follow from the first commit,
and check the enhancements progressively. Every commit includes a basic description of
what has been changed (it is part of the commit message), and by clicking the "Browse
Files" button in the top right corner of the commit message it is possible to navigate
in the repository exactly as it was after the commit was performed.

A complete list of the commits in this repository is presented below, in the ascending
chronological order in which they were pushed. Start from the first item and keep going
down! :)

1. [Initial commit with the code structure](https://github.com/brunotoffolo/code-with-me/commit/1837c61c6816bc5082e7279db66e1f25c9970513)
2. [Initialize lists to remove possible NPEs](https://github.com/brunotoffolo/code-with-me/commit/58d92b2a6ce7901dd77176beef0fbfc2998b2e89)
3. [Manually initialize list to avoid any exception](https://github.com/brunotoffolo/code-with-me/commit/ca374cb6aa8042e3d3dea15eaffd9769ae2cd5bf)
4. [Enhance checks and throw exceptions in error cases](https://github.com/brunotoffolo/code-with-me/commit/1b3b9303dca8f52cd547b66f79b18553b93b7872)
5. [Create a customized runtime exception](https://github.com/brunotoffolo/code-with-me/commit/86c843e47a18548a918ac8c259d4ec4db1754fa5)
6. [Convert InsufficientFundsException to checked](https://github.com/brunotoffolo/code-with-me/commit/bf17e510261c1c658aed11a93965e143024152c0)
7. [Demonstrate 'finally' block in invoice generation](https://github.com/brunotoffolo/code-with-me/commit/a8f3ce85836ae4bb80856a8f05d4bc1327664f69)
8. [Catch multiple exception types in a single block](https://github.com/brunotoffolo/code-with-me/commit/a37c1ea3dad0846fd623a8581e9d1759eb19d415)
9. [Use try-with-resources to write the invoice file](https://github.com/brunotoffolo/code-with-me/commit/94c5ea9128f19d29f640ae0cb041ba921dd8cb70)

Have fun enjoying this tutorial!