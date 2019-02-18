/**
 * @author Laura Berkholtz
 */

package com.lberkholtz.advancedava.week4.service;

import com.lberkholtz.advancedava.week4.enums.Interval;
import com.lberkholtz.advancedava.week4.model.StockQuote;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class BasicStockService implements StockService {
private StockQuote stockquote;



    public BasicStockService() {
    }
    /**
     * Constructor
     * @param stockquote
     */

    public BasicStockService(StockQuote stockquote) {
        this.stockquote = stockquote;
    }

    /**
     * Get stock price for the date specified - Basic layout
     * override interface method
     *
     * @param symbol the stock symbol to get the price for
     * @return a StockQuote instance for the symbol
     */

    public StockQuote getQuote(String symbol) {
        StockQuote stockquote = new StockQuote(symbol);
        stockquote.setStockPrice(new BigDecimal(100.99));
        Date date = new Date();
        stockquote.setDate(date);
        return stockquote;
    }

    /**
     * Get a list of StockQuotes starting at the from date and one for each day until the
     * until date
     * overrides interface method
     *
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param until the date of the last stock quote
     * @return a list of stock values for the interval specified
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) {

        Calendar workingdate;
        workingdate = from;
        List<StockQuote> returnValue = new ArrayList<>();

         while (workingdate.before(until) || workingdate.equals(until)) {
            StockQuote stockquote = new StockQuote();
            stockquote.setStockSymbol(symbol);
            stockquote.setDate(workingdate.getTime());
            /* generate random value for price until we get an actual stock service */
            BigDecimal price =new BigDecimal(BigInteger.valueOf(new Random().nextInt(10001)), 2);
            BigDecimal divisor = BigDecimal.valueOf(100.00);
            stockquote.setStockPrice(price.divide(divisor));
            returnValue.add(stockquote);

            workingdate.add(Calendar.DAY_OF_YEAR, 1);
        }
        return returnValue;
    }

    /**
     * TODO Note to self - split out duplicate code when feeling clever
     * TODO Tried switch statement with enum and could not get it to work
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param until the date of the last stock quote
     * @param interval ­ the number of StockQuotes to get. E.g. if Interval.DAILY was
     * specified
     * one StockQuote per day will be returned.
     * @return
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, Interval interval){
        Calendar workingdate;
        workingdate = from;
        workingdate.set(Calendar.HOUR_OF_DAY, 0);
        workingdate.set(Calendar.MINUTE, 0);
        workingdate.set(Calendar.SECOND, 0);

        List<StockQuote> returnValue = new ArrayList<>();

        while (workingdate.before(until) || workingdate.equals(until)) {
            StockQuote stockquote = new StockQuote();
            stockquote.setStockSymbol(symbol);
            stockquote.setDate(workingdate.getTime());
            /* generate random value for price until we get an actual stock service */
            BigDecimal price =new BigDecimal(BigInteger.valueOf(new Random().nextInt(10001)), 2);
            BigDecimal divisor = BigDecimal.valueOf(100.00);
            stockquote.setStockPrice(price.divide(divisor));
            returnValue.add(stockquote);
            if (interval == Interval.HOURLY) {
                workingdate.add(Calendar.HOUR_OF_DAY, 1);
            } else if (interval == Interval.DAILY){
                workingdate.add(Calendar.DAY_OF_YEAR, 1);
            } else if (interval == Interval.WEEKLY){
                workingdate.add(Calendar.DAY_OF_YEAR, 7);
            } else if (interval == Interval.MONTHLY){
                workingdate.add(Calendar.MONTH, 1);
            }
            else
                workingdate = until;

        }

        return returnValue;
    }
    }
