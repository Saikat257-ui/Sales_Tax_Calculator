package com.sales.receipt;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getTotalSalesTax() {
        return items.stream().mapToDouble(item -> item.getTax() * item.getQuantity()).sum();
    }

    public double getTotalAmount() {
        return items.stream().mapToDouble(Item::getTotalPrice).sum();
    }

    public void printReceipt() {
        for (Item item : items) {
            System.out.printf("%d %s: %.2f%n", item.getQuantity(), item.getName(), item.getTotalPrice());
        }
        System.out.printf("Sales Taxes: %.2f%n", getTotalSalesTax());
        System.out.printf("Total: %.2f%n", getTotalAmount());
    }
}