# Air Protocol

> 定义十六进制协议和数据实体对象，提供十六进制字符串和实体对象之间的转换工具，其他服务基于第三方Protocol服务进行协议编解码。

### 功能

* 协议编码
* 协议解码
* 模拟数据

### 拓展

若加入了新的模块，它具有独特的数据字段，可通过多态加入新的编解码方法，为新模块的数据提供编解码支持

当前模块：

1. DHT11温湿度模块 

数据格式为
```txt
@Override
    public String toString() {
        return "DHT11DataType{" +
                "imei='" + imei + '\'' +
                ", tempInt='" + tempInt + '\'' +
                ", tempDeci='" + tempDeci + '\'' +
                ", humiInt='" + humiInt + '\'' +
                ", humiDeci='" + humiDeci + '\'' +
                '}';
    }
```

2. GP2Y灰尘PM25模块

数据格式为
```txt
 @Override
    public String toString() {
        return "GP2YDataType{" +
                "imei='" + imei + '\'' +
                ", start='" + start + '\'' +
                ", voutH='" + voutH + '\'' +
                ", voutL='" + voutL + '\'' +
                ", vrefH='" + vrefH + '\'' +
                ", vrefL='" + vrefL + '\'' +
                ", check='" + check + '\'' +
                ", finish='" + finish + '\'' +
                '}';
    }
```

### jar打包

File -> project structure -> Artifacts -> 点击"+"选择jar，然后选择"from modules with dependencies -> "extract to the target JAR"

完成后，点击OK，Apply等按钮，回到IDEA的主菜单，选择“Build - Build Artifacts”下的“Build”或者“Rebuild”即可生成最终的可运行的jar，在\out\artifacts\xxxx_jar下面找到生成的目标jar。

> 提供已经打包好的JAR : Air-Protocol.jar

### 其他服务引用

File -> project structure -> Libraries -> 添加本地jar包，即可使用。

## 编码十六进制协议

根据不同模块的数据对象，对象属性为十进制数据 -> 转换为十六进制协议字符串

```
import com.ten.air.protocol.ProtocolEncode;
import com.ten.air.protocol.bean.AirRecord;

use case:
```

```
// 1. AirRecord对象编码
String encode(AirRecord airRecord){
    // 获取记录对象，六个必需属性
    AirRecord airRecord = [imei, source, temperature, humidity, pm25, undefinedData];
    // 将对象编码为十六机制协议字符串
    String protocol = ProtocolEncode.toHexProtocol(airRecord);
}    
```

```
// 2. DHT11DataType对象编码
String encode(DHT11DataType dataType){
    // 获取记录对象，五个必需属性
    AirRecord airRecord = [imei, tempInt, tempDeci, humiInt, humiDeci];
    // 将对象编码为十六机制协议字符串
    String protocol = ProtocolEncode.toHexProtocol(dataType);
}   
``` 

```
// 3. GP2YDataType对象编码
String encode(GP2YDataType dataType){
    // 获取记录对象，三个必需属性
    AirRecord airRecord = [imei, voutH, voutL];
    // 将对象编码为十六机制协议字符串
    String protocol = ProtocolEncode.toHexProtocol(dataType);
}    
```

## 解码十六进制协议

将十六进制的协议字符串，转换为十进制的数据属性，封装在AirRecord对象中返回

```
import com.ten.air.protocol.ProtocolDecode;
import com.ten.air.protocol.bean.AirRecord;

use case:

AirRecord decode(String protocol){
    // 将十六进制的协议字符串，转换为十进制的数据属性，封装在AirRecord对象中返回
    AirRecord airRecord = ProtocolDecode.parseProtocol(protocol);
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

