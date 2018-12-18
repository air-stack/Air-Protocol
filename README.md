# Air Protocol

> 定义十六进制协议和数据实体对象，提供十六进制字符串和实体对象之间的转换工具，其他服务基于第三方Protocol服务进行协议编解码。

### 功能

* Air协议编码
* Air协议解码
* 产生模拟数据

### jar打包

File -> project structure -> Artifacts -> 点击"+"选择jar，然后选择"from modules with dependencies -> "extract to the target JAR"

完成后，点击OK，Apply等按钮，回到IDEA的主菜单，选择“Build - Build Artifacts”下的“Build”或者“Rebuild”即可生成最终的可运行的jar，在\out\artifacts\xxxx_jar下面找到生成的目标jar。

### 引用

File -> project structure -> Libraries -> 添加本地jar包，即可使用。

## 编码十六进制协议

将十进制的数据属性，转换为十六进制协议字符串

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

