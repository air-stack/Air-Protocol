package com.ten.air.protocol;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static junit.framework.TestCase.assertEquals;

/**
 * ProtocolGenerator Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十二月 17, 2018</pre>
 */
public class ProtocolGeneratorTest {
    /**
     * 协议字符串长度
     */
    private static final int PROTOCOL_LENGTH = 72;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: genMockProtocol(String imei)
     */
    @Test
    public void testGenMockProtocol() throws Exception {
        // 测试IMEI为空
        String imei1 = "";
        String protocol1 = ProtocolGenerator.genMockProtocol(imei1);
        assertEquals(protocol1.length(), PROTOCOL_LENGTH);

        // 测试IMEI过长
        String imei2 = "112233445566778899AABBCCDDEEFFGGHH";
        String protocol2 = ProtocolGenerator.genMockProtocol(imei1);
        assertEquals(protocol2.length(), PROTOCOL_LENGTH);

        // 测试IMEI非法字符
        String imei3 = "QQWWEERRTTYYUU";
        String protocol3 = ProtocolGenerator.genMockProtocol(imei1);
        assertEquals(protocol3.length(), PROTOCOL_LENGTH);
    }

    /**
     * Method: getNewAir()
     */
    @Test
    public void testGetNewAir() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getPm25()
     */
    @Test
    public void testGetPm25() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setPm25(String pm25)
     */
    @Test
    public void testSetPm25() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getSo2()
     */
    @Test
    public void testGetSo2() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setSo2(String so2)
     */
    @Test
    public void testSetSo2() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getTemperature()
     */
    @Test
    public void testGetTemperature() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setTemperature(String temperature)
     */
    @Test
    public void testSetTemperature() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getCo2()
     */
    @Test
    public void testGetCo2() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setCo2(String co2)
     */
    @Test
    public void testSetCo2() throws Exception {
//TODO: Test goes here... 
    }


} 
