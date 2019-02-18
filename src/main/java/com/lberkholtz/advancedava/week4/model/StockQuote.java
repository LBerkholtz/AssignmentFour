/**
 * @author Laura Berkholtz
 */

package com.lberkholtz.advancedava.week4.model;

import org.apache.http.annotation.Immutable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Container class stockquote
 *
 */

@Immutable




public class StockQuote {
    private String stockSymbol;//the string symbol for the stock
    private Date date; //the date of the quote
    private BigDecimal stockPrice;  //the price of the stock


    /**
     * Returns an empty instance of stock quote
     */

    public StockQuote() {
    }

    /**
     * Returns a stock quote if only a symbol is sent
     * @param stocksymbol
     */

    public StockQuote(String stocksymbol) {
        this.stockSymbol = stocksymbol;
    }

    /**
     * Returns a stock quote
     *
     * @param stockSymbol
     * @param date
     * @param stockPrice
     */
    public StockQuote(String stockSymbol, Date date, BigDecimal stockPrice) {
        this.stockSymbol = stockSymbol;
        this.date = date;
        this.stockPrice = stockPrice;
    }

    /**
     *
     * @return stocksymbol
     */
    public String getStockSymbol() {

        return stockSymbol;
    }

    /**
     *
     * @param stockSymbol
     */
    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    /**
     *
     * @return date
     */

    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return stockPrice
     */

    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    /**
     *
     * @param stockPrice
     */

    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
    }

    @Override
    public String  toString() {
        return "StockQuote{" +
                "stockSymbol='" + stockSymbol + '\'' +
                ", date=" + date +
                ", stockPrice=" + stockPrice +
                '}';
    }
}
