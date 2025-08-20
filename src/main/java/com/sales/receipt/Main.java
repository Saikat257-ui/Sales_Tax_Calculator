package com.sales.receipt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Receipt receipt = new Receipt();

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
                    Item item = parseItem(line);
                    receipt.addItem(item);
                } catch (Exception e) {
                    System.out.println("Invalid input format. Please use 'quantity name at price'.");
                }
            }
        }
        scanner.close();
    }

    private static Item parseItem(String line) {
        String[] parts = line.split(" at ");
        double price = Double.parseDouble(parts[1]);
        String namePart = parts[0].substring(parts[0].indexOf(' ') + 1);
        int quantity = Integer.parseInt(parts[0].substring(0, parts[0].indexOf(' ')));
        boolean isImported = namePart.contains("imported");
        boolean isExempt = namePart.contains("book") || namePart.contains("chocolate") || namePart.contains("pills");

        return new Item(namePart, price, quantity, isImported, isExempt);
    }
}