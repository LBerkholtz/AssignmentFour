/**
 * @author Laura Berkholtz
 */


package com.lberkholtz.advancedava.week4.main;

import com.lberkholtz.advancedava.week4.model.StockQuote;
import com.lberkholtz.advancedava.week4.service.StockService;
import com.lberkholtz.advancedava.week4.service.StockServiceFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * This class gets either a single or a list of stock quotes depending on the parameters passed to it
 * It will return a stock quote for todays date if just a symbol is passed to it
 * If a symbol, a start date and an end date are passed it will get quotes for each day beginning
 * at the start date and going through and including the end date.
 */



public class StockQuoteApplication {

    /**
     * @param args arg[0] is the symbol for the stock
     *             arg[1] is the starting date for the list of quotes
     *             arg[2] is the ending date for the list of quotes
     * @throws ParseException
     */

    public static void main(String[] args) throws ParseException {

        StockService stockservice = new StockServiceFactory().getStockService("basic");

    /**
    * Check args length and if there is only one, pass only the symbol to the getQuote method
     * Otherwise send all args to stock quote and get a list of quotes
    */
        if (args.length == 1) {
            StockQuote singlestockquote = stockservice.getQuote(args[0]);
            System.out.println(singlestockquote.toString());

        } else if (args.length != 0) {

            String fromDate = args[1];
            String untilDate = args[2];

            SimpleDateFormat startdateformat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat enddateformat = new SimpleDateFormat("yyyy-MM-dd");

            Calendar startDate = Calendar.getInstance();
            Calendar endDate = Calendar.getInstance();

            try {

                startDate.setTime(startdateformat.parse(fromDate));
                endDate.setTime(enddateformat.parse(untilDate));

                } catch (ParseException e) {

                System.out.println("Invalid dates. Program is terminating");
                System.exit(-1);

            }

            List<StockQuote> stockquotelist = stockservice.getQuote(args[0], startDate, endDate);

            for (StockQuote tempstockquote : stockquotelist) {
                System.out.println(tempstockquote.toString());
            }
        }
        }
    }



