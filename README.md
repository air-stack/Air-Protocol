# Air Protocol

> Protocol code util for Air. Air协议编解码工具. 

## 功能

* Air协议编码
* Air协议解码
* 产生模拟数据

## Maven引用



## 编码十六进制协议

将十进制数据属性转换为十六进制字符串

```
import com.ten.air.protocol.ProtocolEncode;
import com.ten.air.protocol.bean.AirRecord;

use case:

String encode(AirRecord airRecord){
    // 获取记录对象，六个必需属性
    AirRecord airRecord = [imei, source, temperature, pm25, co2, so2];
    // 将对象编码为十六机制协议字符串
    String protocol = ProtocolEncode.toHexProtocol(airRecord);
}    
```

## 解码十六进制协议

将十六进制的数据属性转换为十进制的数据属性

```
import com.ten.air.protocol.ProtocolDecode;
import com.ten.air.protocol.bean.AirRecord;

use case:

AirRecord decode(AirRecord airRecord){
    // 获取记录对象，四个必需属性
    AirRecord airRecord = [temperature, pm25, co2, so2];
    // 将对象编码为十六机制协议字符串
    AirRecord protocol = ProtocolDecode.parseProtocol(airRecord);
}
```

## 生成随机模拟记录数据

生成随机模拟数据，返回十六进制协议字符串

```
import com.ten.air.protocol.ProtocolGenerator;

use case:

String generate(String imei){
    // 根据IMEI设备号随机生成记录数据
    String protocol = ProtocolGenerator.genMockProtocol(imei);
}
```

## 单元测试

ProtocolDecodeTest : PASS

ProtocolEncodeTest : PASS

ProtocolGeneratorTest : PASS

