package com.sales.receipt;

import org.junit.Test;
import static org.junit.Assert.*;

public class InputParserTest {

    private InputParser parser = new InputParser();

    @Test
    public void testValidInput() {
        Item item = parser.parse("1 book at 12.49");
        assertEquals("book", item.getName());
        assertEquals(12.49, item.getPrice(), 0.001);
        assertEquals(1, item.getQuantity());
        assertFalse(item.isImported());
        assertTrue(item.isExempt());
    }

    @Test
    public void testValidInputWithImported() {
        Item item = parser.parse("1 imported bottle of perfume at 47.50");
        assertEquals("imported bottle of perfume", item.getName());
        assertEquals(47.50, item.getPrice(), 0.001);
        assertEquals(1, item.getQuantity());
        assertTrue(item.isImported());
        assertFalse(item.isExempt());
    }

    @Test
    public void testValidInputWithMultipleWordsInName() {
        Item item = parser.parse("1 box of imported chocolates at 11.25");
        assertEquals("box of imported chocolates", item.getName());
        assertEquals(11.25, item.getPrice(), 0.001);
        assertEquals(1, item.getQuantity());
        assertTrue(item.isImported());
        assertTrue(item.isExempt());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInput_missingAt() {
        parser.parse("1 book 12.49");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInput_missingQuantity() {
        parser.parse("book at 12.49");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInput_missingPrice() {
        parser.parse("1 book at");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInput_textInPrice() {
        parser.parse("1 book at abc");
    }

    @Test
    public void testValidInputWithExtraWhitespace() {
        Item item = parser.parse("  1   box of imported chocolates   at   11.25  ");
        assertEquals("box of imported chocolates", item.getName());
        assertEquals(11.25, item.getPrice(), 0.001);
        assertEquals(1, item.getQuantity());
        assertTrue(item.isImported());
        assertTrue(item.isExempt());
    }
}