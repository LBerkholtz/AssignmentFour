/**
 * @author Laura Berkholtz
 */

package com.lberkholtz.advancedava.week4.main;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertNull;

/**
 * TODO ask about testing a main method
 * Tests the StockQuoteApplication class
 * This is really a dummy test for now until I figure out how to test a main method
 */

public class StockQuoteApplicationTest {
    String[] args = {"APPL", "2018-01-01", "2018-01-10"};

    @Test
    public void testStockQuoteApplication()throws ParseException {
        StockQuoteApplication.main(args);
    }

}