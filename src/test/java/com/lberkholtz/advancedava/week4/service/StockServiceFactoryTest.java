/**
 * @author Laura Berkholtz
 */


package com.lberkholtz.advancedava.week4.service;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;


/**
 * Unit test for Stock Quote
 */
public class StockServiceFactoryTest{
    StockServiceFactory stockservicefactory = new StockServiceFactory();

    /**
     * Test StockService method to see if it passes correctly
     */
    @Test
    public void testGetStockService() {
        assertThat(stockservicefactory.getStockService(), instanceOf(BasicStockService.class));
    }
}


