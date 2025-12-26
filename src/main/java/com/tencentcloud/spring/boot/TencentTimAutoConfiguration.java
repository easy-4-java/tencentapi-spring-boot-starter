package com.tencentcloud.spring.boot;

import com.tencentcloud.spring.boot.tim.TencentTimOption;
import com.tencentcloud.spring.boot.tim.TencentTimTemplate;
import com.tencentcloud.spring.boot.tim.TimInfoProvider;
import com.tencentyun.TLSSigAPIv2;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(TLSSigAPIv2.class)
@ConditionalOnProperty(prefix = TencentTimProperties.PREFIX, value = "enabled", havingValue = "true")
@EnableConfigurationProperties({ TencentCloudProperties.class, TencentTimProperties.class })
public class TencentTimAutoConfiguration {
	
	@Bean
	public TencentTimTemplate tencentTimTemplate(
			TencentTimProperties timProperties,
			ObjectProvider<OkHttpClient> okhttp3ClientProvider,
			ObjectProvider<TimInfoProvider> timUserIdProvider) {
		OkHttpClient okhttp3Client = okhttp3ClientProvider.getIfAvailable(() -> new OkHttpClient.Builder().build());
		return new TencentTimTemplate(timProperties, okhttp3Client, timUserIdProvider.getIfAvailable(() -> sdkAppId -> timProperties));
	}

}
