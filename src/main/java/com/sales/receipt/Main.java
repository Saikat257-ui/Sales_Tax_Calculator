package com.sales.receipt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Receipt receipt = new Receipt();
        InputParser parser = new InputParser();

        System.out.println("Enter item details (e.g., '1 book at 12.49'). Press enter on an empty line to finish:");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                if (!receipt.isEmpty()) {
                    receipt.printReceipt();
                    receipt = new Receipt();
                    System.out.println();
                } else {
                    break;
                }
            } else {
                try {
                    Item item = parser.parse(line);
                    receipt.addItem(item);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        scanner.close();
    }
}