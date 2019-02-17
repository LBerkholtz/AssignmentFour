/**
 * @author Laura Berkholtz
 */

package com.lberkholtz.advancedava.week4.service;

/**
 * Returns a concrete implementation of the
 * interface depending on the parameter passed
 */
public class StockServiceFactory{
    /**
     * Just coding for BasicStockService now, can add more types of StockService in the future.
     * @param stockServiceType what type of stock service is needed. For now we just have Basic
     * @return
     */

    public StockService getStockService(String stockServiceType) {

        if (stockServiceType.equalsIgnoreCase("basic"))
            return new BasicStockService();
        else
            return null;

    }
}
