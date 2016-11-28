# Spring MVC

The contents of this project were implemented to be used as the initial setup for a _Code With Me_ session regarding Spring Framework and Spring MVC. It essentially contains a basic web application with the Spring Framework preconfigured (version 4.3.4).

This application can be used as a quick start for any legacy Spring application that needs just Spring MVC to work as intended. It has a predefined controller and a dispatcher servlet establishing a very simple navigation between two pages.

## Downloading dependencies

Run `mvn clean install` in the project's root folder to download the dependencies and build the output WAR file.

## Importing the project in Eclipse

In Eclipse, go to _File > Import > Maven > Existing Maven Projects_ and select the `pom.xml` file in the root folder of the application.

Configure Apache Tomcat to deploy the server on by right-clicking the project in Eclipse and then going to _Properties > Java Build Path > Libraries_ and then clicking on _Add Library... > Server Runtime_.

If you face an exception stating `java.lang.ClassNotFoundException: org.springframework.web.context.ContextLoaderListener` when executing the project:

1. Open the project's properties (e.g., right-click on the project's name in the project explorer and select "Properties").
2. Select "Deployment Assembly".
3. Click the "Add..." button on the right margin.
4. Select "Java Build Path Entries" from the menu of Directive Type and click "Next".
5. Select "Maven Dependencies" from the Java Build Path Entries menu and click "Finish".