/**
 * @author Laura Berkholtz
 */

package com.lberkholtz.advancedava.week4.service;

import com.lberkholtz.advancedava.week4.model.StockQuote;

/**
 * Returns a concrete implementation of the
 * interface depending on the parameter passed
 */
public class StockServiceFactory{
    /**
     * Just coding for BasicStockService now, can add more types of StockService in the future.
     * @return
     */

    public static StockService getStockService() {
            return new BasicStockService();
    }
}
