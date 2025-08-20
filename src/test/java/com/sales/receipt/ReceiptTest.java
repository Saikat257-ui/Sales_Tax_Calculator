package com.sales.receipt;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReceiptTest {

    @Test
    public void testReceiptTotals() {
        Receipt receipt = new Receipt();
        receipt.addItem(new Item("book", 12.49, 1, false, true));
        receipt.addItem(new Item("music CD", 14.99, 1, false, false));
        receipt.addItem(new Item("chocolate bar", 0.85, 1, false, true));

        assertEquals(1.50, receipt.getTotalSalesTax(), 0.001);
        assertEquals(29.83, receipt.getTotalAmount(), 0.001);
    }
}