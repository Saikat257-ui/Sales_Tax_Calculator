package com.sales.receipt;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item {
    private String name;
    private double price;
    private int quantity;
    private boolean isImported;
    private boolean isExempt;

    private static final BigDecimal BASIC_SALES_TAX_RATE = new BigDecimal("0.10");
    private static final BigDecimal IMPORT_DUTY_RATE = new BigDecimal("0.05");
    private static final BigDecimal ROUNDING_FACTOR = new BigDecimal("0.05");

    public Item(String name, double price, int quantity, boolean isImported, boolean isExempt) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isImported = isImported;
        this.isExempt = isExempt;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isExempt() {
        return isExempt;
    }

    public double getTax() {
        BigDecimal price = BigDecimal.valueOf(getPrice());
        BigDecimal tax = BigDecimal.ZERO;

        if (!isExempt()) {
            tax = tax.add(price.multiply(BASIC_SALES_TAX_RATE));
        }

        if (isImported()) {
            tax = tax.add(price.multiply(IMPORT_DUTY_RATE));
        }

        return roundUpToNearestFiveCents(tax).doubleValue();
    }

    public double getTotalPrice() {
        return (getPrice() * getQuantity()) + (getTax() * getQuantity());
    }

    private BigDecimal roundUpToNearestFiveCents(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal divided = value.divide(ROUNDING_FACTOR, 0, RoundingMode.UP);
        return divided.multiply(ROUNDING_FACTOR);
    }
}