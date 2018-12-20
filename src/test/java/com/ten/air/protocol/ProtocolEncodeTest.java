package com.ten.air.protocol;

import com.ten.air.protocol.bean.AirRecord;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static junit.framework.TestCase.assertEquals;

/**
 * ProtocolEncode Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十二月 17, 2018</pre>
 */
public class ProtocolEncodeTest {
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
     * Method: toHexProtocol(AirRecord airRecord)
     */
    @Test
    public void testToHexProtocol() throws Exception {
        // 测试数据为空
        AirRecord airRecord1 = new AirRecord();
        airRecord1.setImei("");
        airRecord1.setSource("");
        airRecord1.setTemperature("");
        airRecord1.setPm25("");
        airRecord1.setHumidity("");
        airRecord1.setUndefinedData("");

        String protocol1 = ProtocolEncode.toHexProtocol(airRecord1);
        assertEquals(protocol1.length(), PROTOCOL_LENGTH);

        // 测试数据非法字符
        AirRecord airRecord2 = new AirRecord();
        airRecord2.setImei("23nga.,pwj");
        airRecord2.setSource("324a");
        airRecord2.setTemperature("GGEE");
        airRecord2.setPm25("ZZYY");
        airRecord2.setHumidity("2G5N");
        airRecord2.setUndefinedData(".0A,");

        String protocol2 = ProtocolEncode.toHexProtocol(airRecord2);
        assertEquals(protocol2.length(), PROTOCOL_LENGTH);
    }

    /**
     * Method: genHexProtocol(String imei, ProtocolGenerator.AirIndex airIndex)
     */
    @Test
    public void testGenHexProtocol() throws Exception {
//TODO: Test goes here... 
    }


    /**
     * Method: genHexTime()
     */
    @Test
    public void testGenHexTime() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ProtocolEncode.getClass().getMethod("genHexTime"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: toHexImei(String imei)
     */
    @Test
    public void testToHexImei() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ProtocolEncode.getClass().getMethod("toHexImei", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: toHexSource(String source)
     */
    @Test
    public void testToHexSource() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ProtocolEncode.getClass().getMethod("toHexSource", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: toHexIntegerData(String data)
     */
    @Test
    public void testToHexIntegerData() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ProtocolEncode.getClass().getMethod("toHexIntegerData", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: toHexDecimalData(String data)
     */
    @Test
    public void testToHexDecimalData() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ProtocolEncode.getClass().getMethod("toHexDecimalData", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: fillData(String data, int expect)
     */
    @Test
    public void testFillData() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ProtocolEncode.getClass().getMethod("fillData", String.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
