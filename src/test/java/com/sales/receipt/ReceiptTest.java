package com.sales.receipt;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReceiptTest {

    @Test
    public void testReceiptBasket1() {
        Receipt receipt = new Receipt();
        receipt.addItem(new Item("book", 12.49, 1, false, true));
        receipt.addItem(new Item("music CD", 14.99, 1, false, false));
        receipt.addItem(new Item("chocolate bar", 0.85, 1, false, true));

        assertEquals(1.50, receipt.getTotalSalesTax(), 0.001);
        assertEquals(29.83, receipt.getTotalAmount(), 0.001);
    }

    @Test
    public void testReceiptBasket2() {
        Receipt receipt = new Receipt();
        receipt.addItem(new Item("imported box of chocolates", 10.00, 1, true, true));
        receipt.addItem(new Item("imported bottle of perfume", 47.50, 1, true, false));

        assertEquals(7.65, receipt.getTotalSalesTax(), 0.001);
        assertEquals(65.15, receipt.getTotalAmount(), 0.001);
    }

    @Test
    public void testReceiptBasket3() {
        Receipt receipt = new Receipt();
        receipt.addItem(new Item("imported bottle of perfume", 27.99, 1, true, false));
        receipt.addItem(new Item("bottle of perfume", 18.99, 1, false, false));
        receipt.addItem(new Item("packet of headache pills", 9.75, 1, false, true));
        receipt.addItem(new Item("box of imported chocolates", 11.25, 1, true, true));

        assertEquals(6.70, receipt.getTotalSalesTax(), 0.001);
        assertEquals(74.68, receipt.getTotalAmount(), 0.001);
    }
	
    @Test
    public void testReceiptWithZeroPriceItem() {
        Receipt receipt = new Receipt();
        receipt.addItem(new Item("freebie", 0.00, 1, false, true));
        assertEquals(0.00, receipt.getTotalSalesTax(), 0.001);
        assertEquals(0.00, receipt.getTotalAmount(), 0.001);
    }

    @Test
    public void testReceiptWithSingleItem() {
        Receipt receipt = new Receipt();
        receipt.addItem(new Item("music CD", 14.99, 1, false, false));
        assertEquals(1.50, receipt.getTotalSalesTax(), 0.001);
        assertEquals(16.49, receipt.getTotalAmount(), 0.001);
    }
}