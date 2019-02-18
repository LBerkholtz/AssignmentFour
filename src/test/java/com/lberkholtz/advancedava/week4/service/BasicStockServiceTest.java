/**
 * @author Laura Berkholtz
 */


package com.lberkholtz.advancedava.week4.service;

import com.lberkholtz.advancedava.week4.enums.Interval;
import com.lberkholtz.advancedava.week4.model.StockQuote;

import org.junit.Test;

import static org.junit.Assert.* ;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


/**
 * Unit test for Stock Quote
 */
public class BasicStockServiceTest {


    /**
     * Test GetQuote method with a single parameter
     */
    @Test
    public void testGetQuote() {
        StockQuote stockquote = new StockQuote();
        StockServiceFactory stockservicefactory = new StockServiceFactory();
        StockService stockservice = stockservicefactory.getStockService();
        BigDecimal price = new BigDecimal(100.99);
        stockquote = stockservice.getQuote("APPL");
        stockquote.setStockPrice(price);
        assertEquals("verify Stock Symbol", stockquote.getStockSymbol(),"APPL");
        assertTrue("verify stock price", stockquote.getStockPrice().equals(price));

    }

    @Test
    /**
     * Test the stockQuote method with from and until dates
     */
    public void testGetQuoteFromUntil() {
        StockServiceFactory stockservicefactory = new StockServiceFactory();
        StockService basicstockservice = stockservicefactory.getStockService();
        String startdate = "2018-01-01";  // Start date
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar from = Calendar.getInstance();
        try {
            from.setTime(simpledateformat.parse(startdate));
        } catch (ParseException e) {
            String message = "Invalid dates. Program is terminating";
            System.out.println(message);

        }
        String enddate = "2018-01-10";  // End date
        Calendar until = Calendar.getInstance();
        try {
            until.setTime(simpledateformat.parse(enddate));
        } catch (ParseException e) {
            String message = "Invalid dates. Program is terminating";
            System.out.println(message);

        }

        List<StockQuote> stockhistory = basicstockservice.getQuote("APPL",from,until);
        assertEquals("verify number of quotes",10, stockhistory.size());
    }
    @Test
    /**
     * Test the stockQuote method with from and until dates
     */
    public void testGetQuoteInterval() {
        StockServiceFactory stockservicefactory = new StockServiceFactory();
        StockService stockservice = stockservicefactory.getStockService();
        String startdate = "2018-01-01";  // Start date
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar from = Calendar.getInstance();
        try {
            from.setTime(simpledateformat.parse(startdate));
        } catch (ParseException e) {
            String message = "Invalid dates. Program is terminating";
            System.out.println(message);

        }
        String enddate = "2018-01-10";  // End date
        Calendar until = Calendar.getInstance();
        try {
            until.setTime(simpledateformat.parse(enddate));
        } catch (ParseException e) {
            String message = "Invalid dates. Program is terminating";
            System.out.println(message);

        }
        Interval interval = Interval.DAILY;

        List<StockQuote> stockhistory = stockservice.getQuote("APPL",from,until,interval);
        assertEquals("verify number of quotes",10, stockhistory.size());
    }


    }




