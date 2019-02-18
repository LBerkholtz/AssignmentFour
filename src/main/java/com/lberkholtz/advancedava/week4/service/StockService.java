// Written by Laura Berkholtz
package com.lberkholtz.advancedava.week4.service;

import com.lberkholtz.advancedava.week4.enums.Interval;
import com.lberkholtz.advancedava.week4.model.StockQuote;
import java.util.Calendar;
import java.util.List;


public interface StockService {
    /**
     * Return the current price for a share of stock for the
     * given symbol
     * @param symbol the stock symbol of the company you want a
     * quote for e.g. APPL for APPLE
     * @return a StockQuote instance
     */
    StockQuote getQuote(String symbol);
    /**
     * Get a historical list of stock quotes for the provided
     * symbol
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param until the date of the last stock quote
     * @return a list of StockQuote instances.
     * One for each day in the range specified.
     */
    List<StockQuote> getQuote(String symbol, Calendar from,
                              Calendar until);

    /**
     * Get a historical list of stock quotes for the provide symbol
     * This method will return one StockQuote per interval specified.
     *
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param until the date of the last stock quote
     * @param interval ­ the number of StockQuotes to get. E.g. if Interval.DAILY was
     * specified
     * one StockQuote per day will be returned.
     * @return a list of StockQuote instances. One for each interval in the range specified.
     */
    List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, Interval interval);
}


