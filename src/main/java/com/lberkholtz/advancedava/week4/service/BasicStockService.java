/**
 * @author Laura Berkholtz
 */

package com.lberkholtz.advancedava.week4.service;

import com.lberkholtz.advancedava.week4.model.StockQuote;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class BasicStockService implements StockService {
private StockService stockService;
private StockQuote stockquote;

    public BasicStockService() {
    }

    /**
    * Create a new BasicStockService instance
    *
    * @param stockService used to get the stockservice
    */

public BasicStockService(StockService stockService){
        this.stockService=stockService;
        }
    /**
     * Get stock price for the date specified - Basic layout
     * override interface method
     *
     * @param symbol the stock symbol to get the price for
     * @return a StockQuote instance for the symbol
     */

    public StockQuote getQuote(String symbol) {
        StockQuote stockquote = new StockQuote();
        stockquote.setStockSymbol(symbol);
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
     * @return
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) {

        Calendar workingdate = Calendar.getInstance();
        workingdate = from;
        System.out.println (from);
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

    }
