# Sales Receipt Generator

This is a simple Java command-line application that generates a sales receipt for a list of items. It calculates the total price for each item, including sales tax and import duties, and then prints a receipt with the total sales tax and the grand total.

## Features

*   **Sales Tax Calculation:** Calculates a basic sales tax of 10% on all items, except for books, food, and medical products.
*   **Import Duty:** Calculates an additional import duty of 5% on all imported items.
*   **Tax Rounding:** The calculated tax for each item is rounded up to the nearest 0.05.
*   **Rich Domain Model:** The application follows a rich domain model, where business logic is encapsulated within the domain objects (`Item`, `Receipt`).
*   **Interactive Input:** The application accepts item details interactively from the command line.

## How to Build and Run the Application

This project uses Apache Maven for building and managing dependencies.

### Prerequisites

*   Java Development Kit (JDK) 8 or higher
*   Apache Maven

### Building the Project

To build the project and create a JAR file, run the following command from the root directory of the project:

```sh
mvn clean install
```

### Running the Application

Once the project is built, you can run the application using the following command:

```sh
mvn exec:java
```

The application will then prompt you to enter the item details.

### Running the Tests

To run the unit tests, use the following command:

```sh
mvn test