package com.sales.receipt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final Pattern INPUT_PATTERN = Pattern.compile("(\\d+)\\s+(.+)\\s+at\\s+(\\d+\\.\\d{2})");

    public Item parse(String input) {
        Matcher matcher = INPUT_PATTERN.matcher(input.trim());

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid input format. Please use 'quantity name at price'.");
        }

        int quantity = Integer.parseInt(matcher.group(1));
        String name = matcher.group(2);
        double price = Double.parseDouble(matcher.group(3));

        boolean isImported = name.contains("imported");
        boolean isExempt = name.contains("book") || name.contains("chocolate") || name.contains("pills");

        return new Item(name, price, quantity, isImported, isExempt);
    }
}