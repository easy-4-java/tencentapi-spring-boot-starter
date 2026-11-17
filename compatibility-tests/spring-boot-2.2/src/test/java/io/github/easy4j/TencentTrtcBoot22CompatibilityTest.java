package io.github.easy4j;

import com.tencentcloud.spring.boot.TencentTrtcAutoConfiguration;
import com.tencentcloud.spring.boot.trtc.TencentTrtcTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.ConfigurableApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/** 验证 Spring Boot 2.2.10 下 TRTC 的启用条件及模板装配。 */
class TencentTrtcBoot22CompatibilityTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(TencentTrtcAutoConfiguration.class))
            .withPropertyValues("tencent.cloud.trtc.secret-id=test-id",
                    "tencent.cloud.trtc.secret-key=test-key",
                    "tencent.cloud.trtc.region=ap-guangzhou");

    @Test
    void createsTemplateWhenEnabled() {
        contextRunner.withPropertyValues("tencent.cloud.trtc.enabled=true")
                .run(context -> assertThat(context).hasSingleBean(TencentTrtcTemplate.class));
    }

    @Test
    void doesNotCreateTemplateWhenDisabled() {
        contextRunner.run(context -> assertThat(context).doesNotHaveBean(TencentTrtcTemplate.class));
    }

    @Test
    void discoversTrtcAutoConfigurationFromStarter() {
        try (ConfigurableApplicationContext context = new SpringApplicationBuilder(ConsumerApplication.class)
                .web(WebApplicationType.NONE)
                .properties("tencent.cloud.trtc.enabled=true",
                        "tencent.cloud.trtc.secret-id=test-id",
                        "tencent.cloud.trtc.secret-key=test-key",
                        "tencent.cloud.trtc.region=ap-guangzhou")
                .run()) {
            assertThat(context.getBeanNamesForType(TencentTrtcTemplate.class)).hasSize(1);
        }
    }

    @SpringBootConfiguration
    @EnableAutoConfiguration
    static class ConsumerApplication {
    }
}
