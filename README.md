<a id="readme-top"></a>

<div align="center">

# tencentapi-spring-boot-starter

**Spring Boot Starter for tencentapi**

[![Maven Central](https://img.shields.io/maven-central/v/io.github.easy4j/tencentapi-spring-boot-starter)](https://github.com/easy-4-java/tencentapi-spring-boot-starter)
[![Java](https://img.shields.io/badge/Java-17-orange)](#3-requirements-and-compatibility)
[![License](https://img.shields.io/badge/license-Apache-2.0-green)](https://www.apache.org/licenses/LICENSE-2.0)

[简体中文](./README.zh-CN.md) | [English](./README.md)

[Positioning](#1-positioning) · [Capabilities](#2-core-capabilities) ·
[Dependency](#5-dependency) · [Quick Start](#6-quick-start) ·
[Configuration](#7-configuration-reference) · [Versions](#9-version-lines-and-compatibility) ·
[Build](#10-build-and-test) · [License](#12-license)

</div>

---

> **Current Version**：`2.0.1-SNAPSHOT`<br>
> **JDK Baseline**：`17`<br>
> **Group ID**：`io.github.easy4j`<br>
> **Artifact ID**：`tencentapi-spring-boot-starter`<br>
> **License**：Apache License 2.0<br>

## 1. Positioning

**tencentapi-spring-boot-starter** is a Spring Boot starter that integrates **tencentapi** for applications using tencentapi. It provides auto-configuration, property binding, and ready-to-use beans so that applications can consume tencentapi capabilities with minimal setup.

| Dimension | Description |
|---|---|
| Type | Spring Boot Starter |
| Consumers | Spring Boot applications using tencentapi |
| Core Capabilities | auto-configuration, property binding, ready-to-use beans for tencentapi |
| JDK | `17` |
| Coordinates | `io.github.easy4j:tencentapi-spring-boot-starter:2.0.1-SNAPSHOT` |
| Config Prefix | `tencentapi` |

## 2. Core Capabilities

| Capability | Status | Description |
|---|:---:|---|
| Auto-configuration | ✅ Stable | Registers tencentapi beans automatically |
| Property Binding | ✅ Stable | Binds `tencentapi.*` to `TencentCloudProperties` |
| `LiveClient` bean | ✅ Stable | Auto-registered via TencentLiveAutoConfiguration, TencentSmsAutoConfiguration, TencentTimAutoConfiguration, TencentTrtcAutoConfiguration |

## 3. Requirements and Compatibility

| Dependency | Minimum | Evidence |
|---|---:|---|
| JDK | `17` | `pom.xml` |
| Spring Boot | `2.6.0` | `pom.xml` parent |
| Maven | `3.6+` | Maven Enforcer |

## 4. Auto-configuration

The starter auto-configures the following beans:

| Bean | Condition | Missing Behavior |
|---|---|---|
| `LiveClient` | classpath + property | not created |
| `TencentLiveTemplate` | classpath + property | not created |
| `SmsClient` | classpath + property | not created |
| `TencentSmsTemplate` | classpath + property | not created |
| `TencentTimTemplate` | classpath + property | not created |
| `TrtcClient` | classpath + property | not created |
| `TencentTrtcTemplate` | classpath + property | not created |

Auto-configuration registration:

- `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports` (Spring Boot 2.7+ / 3.x / 4.x)
- `META-INF/spring.factories` (Spring Boot 2.x legacy)

## 5. Dependency

```xml
<dependency>
    <groupId>io.github.easy4j</groupId>
    <artifactId>tencentapi-spring-boot-starter</artifactId>
    <version>2.0.1-SNAPSHOT</version>
</dependency>
```

No additional easy4j component dependencies.

## 6. Quick Start

Spring Boot 2.2.10 users can run the [TRTC compatibility test](compatibility-tests/spring-boot-2.2/README.md) for the `tencent.cloud.trtc.enabled` configuration reported in Issue #1.

### 6.1 Add dependency

Add the dependency above to your `pom.xml`.

### 6.2 Configure

```yaml
tencent:
  cloud:
    trtc:
      enabled: true
      secret-id: ${TENCENT_SECRET_ID}
      secret-key: ${TENCENT_SECRET_KEY}
      region: ap-guangzhou
```

### 6.3 Use the bean

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

Then inject the auto-configured TRTC bean in your code:

```java
@Autowired
private TencentTrtcTemplate tencentTrtcTemplate;
```

`TencentTrtcAutoConfiguration` only creates this bean when `tencent.cloud.trtc.enabled=true` and `TrtcClient` is on the classpath. The enable flag defaults to `false`. Credentials can also be supplied under `tencent.cloud.secret-id` and `tencent.cloud.secret-key`. This branch uses Spring Boot 2.6.15 as its parent; an application on Boot 2.2.x needs a compatible starter version and its own integration test.

## 7. Configuration Reference

### 7.1 Config Prefix

`tencent.cloud.trtc`

### 7.2 Configuration Items

| Property | Type | Default | Required | Description | Sensitive |
|---|---|---|:---:|---|:---:|
| `tencent.cloud.trtc.enabled` | boolean | `false` | Yes, for TRTC | Create TRTC beans | No |
| `tencent.cloud.trtc.secret-id` | string | none | Yes | Tencent Cloud API ID | Yes |
| `tencent.cloud.trtc.secret-key` | string | none | Yes | Tencent Cloud API key | Yes |
| `tencent.cloud.trtc.region` | string | none | No | TRTC region | No |

## 8. Version Lines and Compatibility

| Branch | JDK | Spring Boot | Component Version | Status |
|---|---:|---:|---|:---:|
| `2.3.x` / `2.7.x` | `8+` | 2.3.x / 2.7.x | `1.0.x` | Maintenance |
| `3.0.x` ~ `3.5.x` | `17` | 3.x | `2.0.x` | Maintenance |
| `4.0.x` / `4.1.x` | `17+` | 4.x | `3.0.x` | Active |

## 9. Build and Test

```bash
mvn clean verify
mvn -pl tencentapi-spring-boot-starter -am test
```

## 10. Troubleshooting

| Symptom | Diagnosis | Resolution |
|---|---|---|
| Bean not created | Check auto-configuration report | Verify `tencentapi.enabled=true` and classpath |
| `ClassNotFoundException` | Missing dependency | Add the required module |
| Version conflict | `mvn dependency:tree` | Use BOM for version alignment |

## 11. Contribution

1. Fork the repository.
2. Create a feature branch.
3. Run `mvn clean verify` before submitting.
4. Submit a pull request.

## 12. License

This project is licensed under the [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0).

---

<div align="center">

[Back to top](#readme-top) · [Issues](https://github.com/easy-4-java/tencentapi-spring-boot-starter/issues) · [Repository](https://github.com/easy-4-java/tencentapi-spring-boot-starter)

</div>
