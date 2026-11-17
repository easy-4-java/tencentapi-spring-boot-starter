<a id="readme-top"></a>

<div align="center">

# tencentapi-spring-boot-starter

**Spring Boot Starter，集成 tencentapi**

[![Maven Central](https://img.shields.io/maven-central/v/io.github.easy4j/tencentapi-spring-boot-starter)](https://github.com/easy-4-java/tencentapi-spring-boot-starter)
[![Java](https://img.shields.io/badge/Java-17-orange)](#3-运行要求与兼容性)
[![License](https://img.shields.io/badge/license-Apache-2.0-green)](https://www.apache.org/licenses/LICENSE-2.0)

[English](./README.md) | [简体中文](./README.zh-CN.md)

[项目定位](#1-项目定位) · [核心能力](#2-核心能力) ·
[引入依赖](#5-引入依赖) · [快速开始](#6-快速开始) ·
[配置参考](#7-配置参考) · [版本线](#8-版本线与兼容性) ·
[构建测试](#9-构建与测试) · [许可证](#12-许可证)

</div>

---

> **当前版本**：`2.0.1-SNAPSHOT`<br>
> **JDK 基线**：`17`<br>
> **Group ID**：`io.github.easy4j`<br>
> **Artifact ID**：`tencentapi-spring-boot-starter`<br>
> **许可证**：Apache License 2.0<br>

## 1. 项目定位

**tencentapi-spring-boot-starter** 是一个面向 使用 tencentapi 的应用 的 Spring Boot Starter，用于将 **tencentapi** 集成到 Spring Boot 应用中。它提供自动装配、属性绑定与开箱即用的 Bean，使应用以最小配置即可使用 tencentapi 的全部能力。

| 维度 | 说明 |
|---|---|
| 类型 | Spring Boot Starter |
| 消费方 | 使用 tencentapi 的 Spring Boot 应用 |
| 核心能力 | 自动装配、属性绑定、开箱即用的 tencentapi Bean |
| JDK | `17` |
| 坐标 | `io.github.easy4j:tencentapi-spring-boot-starter:2.0.1-SNAPSHOT` |
| 配置前缀 | `tencentapi` |

## 2. 核心能力

| 能力 | 状态 | 说明 |
|---|:---:|---|
| 自动装配 | ✅ 稳定 | 自动注册 tencentapi 相关 Bean |
| 属性绑定 | ✅ 稳定 | 绑定 `tencentapi.*` 到 `TencentCloudProperties` |
| `LiveClient` Bean | ✅ 稳定 | 通过 TencentLiveAutoConfiguration, TencentSmsAutoConfiguration, TencentTimAutoConfiguration, TencentTrtcAutoConfiguration 自动注册 |

## 3. 运行要求与兼容性

| 依赖 | 最低版本 | 证据来源 |
|---|---:|---|
| JDK | `17` | `pom.xml` |
| Spring Boot | `2.6.0` | `pom.xml` parent |
| Maven | `3.6+` | Maven Enforcer |

## 4. 自动装配

Starter 自动装配以下 Bean：

| Bean | 条件 | 缺失时行为 |
|---|---|---|
| `LiveClient` | classpath + property | 不创建 |
| `TencentLiveTemplate` | classpath + property | 不创建 |
| `SmsClient` | classpath + property | 不创建 |
| `TencentSmsTemplate` | classpath + property | 不创建 |
| `TencentTimTemplate` | classpath + property | 不创建 |
| `TrtcClient` | classpath + property | 不创建 |
| `TencentTrtcTemplate` | classpath + property | 不创建 |

自动装配注册：

- `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`（Spring Boot 2.7+ / 3.x / 4.x）
- `META-INF/spring.factories`（Spring Boot 2.x 传统方式）

## 5. 引入依赖

```xml
<dependency>
    <groupId>io.github.easy4j</groupId>
    <artifactId>tencentapi-spring-boot-starter</artifactId>
    <version>2.0.1-SNAPSHOT</version>
</dependency>
```

无其他 easy4j 组件依赖。

## 6. 快速开始

### 6.1 引入依赖

在 `pom.xml` 中添加上述依赖。

### 6.2 配置

```yaml
tencent:
  cloud:
    trtc:
      enabled: true
      secret-id: ${TENCENT_SECRET_ID}
      secret-key: ${TENCENT_SECRET_KEY}
      region: ap-guangzhou
```

### 6.3 使用 Bean

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

在业务代码中注入自动装配的 TRTC Bean：

```java
@Autowired
private TencentTrtcTemplate tencentTrtcTemplate;
```

`TencentTrtcAutoConfiguration` 仅在 `tencent.cloud.trtc.enabled=true` 且存在 `TrtcClient` 时创建此 Bean；启用开关默认是 `false`。密钥也可以配置在 `tencent.cloud.secret-id` 和 `tencent.cloud.secret-key`。本分支的 Spring Boot 父版本是 2.6.15；Boot 2.2.x 应选用兼容版本并在应用中做集成测试。

## 7. 配置参考

### 7.1 配置前缀

`tencent.cloud.trtc`

### 7.2 配置项

| 属性 | 类型 | 默认值 | 必填 | 说明 | 敏感 |
|---|---|---|:---:|---|:---:|
| `tencent.cloud.trtc.enabled` | boolean | `false` | 使用 TRTC 时是 | 创建 TRTC Bean | 否 |
| `tencent.cloud.trtc.secret-id` | string | 无 | 是 | 腾讯云 API ID | 是 |
| `tencent.cloud.trtc.secret-key` | string | 无 | 是 | 腾讯云 API Key | 是 |
| `tencent.cloud.trtc.region` | string | 无 | 否 | TRTC 地域 | 否 |

## 8. 版本线与兼容性

| 分支 | JDK | Spring Boot | 组件版本 | 状态 |
|---|---:|---:|---|:---:|
| `2.3.x` / `2.7.x` | `8+` | 2.3.x / 2.7.x | `1.0.x` | 维护中 |
| `3.0.x` ~ `3.5.x` | `17` | 3.x | `2.0.x` | 维护中 |
| `4.0.x` / `4.1.x` | `17+` | 4.x | `3.0.x` | 活跃开发 |

## 9. 构建与测试

```bash
mvn clean verify
mvn -pl tencentapi-spring-boot-starter -am test
```

## 10. 排障

| 症状 | 诊断 | 解决 |
|---|---|---|
| Bean 未创建 | 查看自动装配报告 | 确认 `tencentapi.enabled=true` 与 classpath |
| `ClassNotFoundException` | 缺少依赖 | 引入对应模块 |
| 版本冲突 | `mvn dependency:tree` | 使用 BOM 统一版本 |

## 11. 贡献

1. Fork 本仓库。
2. 创建特性分支。
3. 提交前运行 `mvn clean verify`。
4. 提交 Pull Request。

## 12. 许可证

本项目采用 [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0) 许可证。

---

<div align="center">

[返回顶部](#readme-top) · [问题反馈](https://github.com/easy-4-java/tencentapi-spring-boot-starter/issues) · [仓库地址](https://github.com/easy-4-java/tencentapi-spring-boot-starter)

</div>
