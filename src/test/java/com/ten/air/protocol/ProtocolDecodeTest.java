package com.ten.air.protocol;

import com.ten.air.protocol.bean.AirRecord;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static junit.framework.TestCase.assertEquals;

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
     * Method: parseProtocol(AirRecord airRecord)
     */
    @Test
    public void testParseProtocol() throws Exception {
        // 测试数据为空
        AirRecord airRecord1 = new AirRecord();
        airRecord1.setTemperature("");
        airRecord1.setPm25("");
        airRecord1.setCo2("");
        airRecord1.setSo2("");

        AirRecord protocol1 = ProtocolDecode.parseProtocol(airRecord1);
        assertEquals(protocol1.getTemperature(),"xx.xx");
        assertEquals(protocol1.getPm25(),"x");
        assertEquals(protocol1.getCo2(),"x");
        assertEquals(protocol1.getSo2(),"x");

        // 测试数据非法字符
        AirRecord airRecord2 = new AirRecord();
        airRecord2.setTemperature("GGEE");
        airRecord2.setPm25("ZZYY");
        airRecord2.setCo2("2G5N");
        airRecord2.setSo2(".0A,");

        AirRecord protocol2 = ProtocolDecode.parseProtocol(airRecord2);
        assertEquals(protocol2.getTemperature(),"xx.xx");
        assertEquals(protocol2.getPm25(),"x");
        assertEquals(protocol2.getCo2(),"x");
        assertEquals(protocol2.getSo2(),"x");
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
