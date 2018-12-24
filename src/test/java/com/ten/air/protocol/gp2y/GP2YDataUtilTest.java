package com.ten.air.protocol.gp2y;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static junit.framework.TestCase.assertEquals;

/**
 * GP2YDataUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 24, 2018</pre>
 */
public class GP2YDataUtilTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: calculateDensity(String voutH, String voutL)
     */
    @Test
    public void testCalculateDensity() throws Exception {
        String voutH = "219";
        String voutL = "31";

        String result = GP2YDataUtil.calculateDensity(voutH, voutL);
        assertEquals("94", result);
    }

    /**
     * Method: checkSum(GP2YDataType gp2YDataType)
     */
    @Test
    public void testCheckSum() throws Exception {
//TODO: Test goes here... 
    }


} 
