package com.ten.air.protocol;

import com.ten.air.protocol.bean.AirRecord;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static junit.framework.TestCase.*;

/**
 * ProtocolDecode Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十二月 17, 2018</pre>
 */
public class ProtocolDecodeTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: parseProtocol(String protocol)
     */
    @Test
    public void testParseProtocol() throws Exception {
        // 正常数据
        String protocol1 = "A00F2412080F111E1401112233445566778899AABBCCDDEEFF01190200FA00000000FFFF";
        AirRecord airRecord1 = ProtocolDecode.parseProtocol(protocol1);
        assertNotNull(airRecord1);

        // 缺漏数据
        String protocol2 = "A00F20F111E1401112233445566BCCDDEEFF01190200FA0000FFFF";
        AirRecord airRecord2 = ProtocolDecode.parseProtocol(protocol2);
        assertNull(airRecord2);

        // 异常字符数据
        String protocol3 = "..0F24YXZ80F111E14011122YY445566778899AABBCCDDEEFF01XX0200FA000XX0XXFFFF";
        AirRecord airRecord3 = ProtocolDecode.parseProtocol(protocol3);
        assertNotNull(airRecord3);
    }

    /**
     * Method: toDecimalProtocol(AirRecord airRecord)
     */
    @Test
    public void testToDecimalProtocol() throws Exception {
        // 测试数据为空
        AirRecord airRecord1 = new AirRecord();
        airRecord1.setTemperature("");
        airRecord1.setPm25("");
        airRecord1.setHumidity("");
        airRecord1.setUndefinedData("");

        AirRecord protocol1 = ProtocolDecode.toDecimalProtocol(airRecord1);
        assertEquals(protocol1.getTemperature(), "xx.xx");
        assertEquals(protocol1.getPm25(), "x");
        assertEquals(protocol1.getHumidity(), "xx.xx");
        assertEquals(protocol1.getUndefinedData(), "x");

        // 测试数据非法字符
        AirRecord airRecord2 = new AirRecord();
        airRecord2.setTemperature("GGEE");
        airRecord2.setPm25("ZZYY");
        airRecord2.setHumidity("2G5N");
        airRecord2.setUndefinedData(".0A,");

        AirRecord protocol2 = ProtocolDecode.toDecimalProtocol(airRecord2);
        assertEquals(protocol2.getTemperature(), "xx.xx");
        assertEquals(protocol2.getPm25(), "x");
        assertEquals(protocol2.getHumidity(), "xx.xx");
        assertEquals(protocol2.getUndefinedData(), "x");

        // 测试正常数据
        AirRecord airRecord3 = new AirRecord();
        airRecord3.setTemperature("1122");
        airRecord3.setPm25("1111");
        airRecord3.setHumidity("1122");
        airRecord3.setUndefinedData("1111");

        AirRecord protocol3 = ProtocolDecode.toDecimalProtocol(airRecord3);
        assertEquals(protocol3.getTemperature(), "17.34");
        assertEquals(protocol3.getPm25(), "4369");
        assertEquals(protocol3.getHumidity(), "17.34");
        assertEquals(protocol3.getUndefinedData(), "4369");
    }


    /**
     * Method: parseTemp(String temp)
     */
    @Test
    public void testParseTemp() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ProtocolDecode.getClass().getMethod("parseTemp", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: parsePm25(String pm25)
     */
    @Test
    public void testParsePm25() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ProtocolDecode.getClass().getMethod("parsePm25", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: parseCo2(String co2)
     */
    @Test
    public void testParseCo2() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ProtocolDecode.getClass().getMethod("parseCo2", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: parseSo2(String so2)
     */
    @Test
    public void testParseSo2() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ProtocolDecode.getClass().getMethod("parseSo2", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
