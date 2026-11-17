# Spring Boot 2.2.10 TRTC 兼容性回归

此独立 Maven 项目使用 Issue #1 报告的 Spring Boot `2.2.10.RELEASE` 和 JDK 8，验证 `tencent.cloud.trtc.enabled=true` 时创建 `TencentTrtcTemplate`，未启用时不创建，并通过实际消费方启动验证自动配置发现。测试使用占位密钥，只创建客户端，不调用腾讯云服务。

在仓库根目录执行：

```bash
mvn clean install
mvn -f compatibility-tests/spring-boot-2.2/pom.xml test
```

首条命令将当前 Starter 安装到本地 Maven 仓库，第二条命令由 Spring Boot 2.2.10 的依赖管理运行消费方测试。
