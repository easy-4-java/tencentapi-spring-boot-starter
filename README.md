# tencentapi-spring-boot-starter


#### 组件简介

- 基于 [腾讯云 - 即时通信 IM ](https://cloud.tencent.com/document/product/269/42440) 在线API封装 IM SDK
- 基于 [腾讯云 - 腾讯云短信（Short Message Service，SMS） ](https://cloud.tencent.com/document/product/382/3784) 在线API封装短信发送组件

#### 使用说明

##### 1、Spring Boot 项目添加 Maven 依赖

``` xml
<dependency>
	<groupId>io.github.easy4j</groupId>
	<artifactId>tencentapi-spring-boot-starter</artifactId>
	<version>${project.version}</version>
</dependency>
```

##### 2、在`application.yml`文件中增加如下配置

```yaml
#################################################################################################
### 腾讯IM、SMS、Live配置：
#################################################################################################
tencent:
  tim:
    sdkappid: 222 
    identifier: 
    expire: 1111
    private-key: sss
```

##### 3、使用示例

腾讯云短信（Short Message Service，SMS）

```java
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tencentcloud.spring.boot.sms.TencentSmsTemplate;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;

@SpringBootApplication
public class TencentSmsApplication_Test {
	
	@Autowired
	private TencentSmsTemplate template;
	@Autowired
	private ObjectMapper objectMapper;
	
	@PostConstruct
	public void testSendSms() {

		try {
			SendSmsResponse response = template.send("13733339999", "9781232", "你好");
			System.out.println(objectMapper.writeValueAsString(response));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(TencentSmsApplication_Test.class, args);
	}

}
```

即时通信 IM

```java
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tencentcloud.spring.boot.tim.TencentTimTemplate;
import com.tencentcloud.spring.boot.tim.resp.AccountKickResponse;

@SpringBootApplication
public class TencentTimApplication_Test {
	
	@Autowired
	private TencentTimTemplate template;
	@Autowired
	private ObjectMapper objectMapper;
	
	@PostConstruct
	public void testKick() {

		try {

			AccountKickResponse response =  template.opsForAccount().kick("");
			System.out.println(objectMapper.writeValueAsString(response));
			
			template.opsForAccount().delete(new String[] {"111"});
			template.opsForProfile().portraitGet("111");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(TencentTimApplication_Test.class, args);
	}

}
```

## Jeebiz 技术社区

Jeebiz 技术社区 **微信公共号**、**小程序**，欢迎关注反馈意见和一起交流，关注公众号回复「Jeebiz」拉你入群。

|公共号|小程序|
|---|---|
| ![](https://raw.githubusercontent.com/hiwepy/static/main/images/qrcode_for_gh_1d965ea2dfd1_344.jpg)| ![](https://raw.githubusercontent.com/hiwepy/static/main/images/gh_09d7d00da63e_344.jpg)|
