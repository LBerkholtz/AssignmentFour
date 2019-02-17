/**
 * @author Laura Berkholtz
 */

package com.lberkholtz.advancedava.week4.main;

import org.junit.Test;

import java.text.ParseException;

/**
 * Tests the StockQuoteApplication class
 */

public class StockQuoteApplicationTest {
    String[] args = {"APPL", "2018-01-01", "2018-01-10"};

    @Test
    public void main()throws ParseException {
        StockQuoteApplication.main(args);
    }
}