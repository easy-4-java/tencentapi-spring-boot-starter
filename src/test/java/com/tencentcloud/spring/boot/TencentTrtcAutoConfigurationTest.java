package com.tencentcloud.spring.boot;

import com.tencentcloud.spring.boot.trtc.TencentTrtcTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

class TencentTrtcAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(TencentTrtcAutoConfiguration.class)
            .withPropertyValues("tencent.cloud.trtc.secret-id=test-id",
                    "tencent.cloud.trtc.secret-key=test-key", "tencent.cloud.trtc.region=ap-guangzhou");

    @Test
    void createsTemplateWhenTrtcEnabled() {
        contextRunner.withPropertyValues("tencent.cloud.trtc.enabled=true")
                .run(context -> assertThat(context).hasSingleBean(TencentTrtcTemplate.class));
    }

    @Test
    void doesNotCreateTemplateByDefault() {
        contextRunner.run(context -> assertThat(context).doesNotHaveBean(TencentTrtcTemplate.class));
    }
}
