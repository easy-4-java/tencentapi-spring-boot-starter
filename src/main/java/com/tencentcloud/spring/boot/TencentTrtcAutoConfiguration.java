package com.tencentcloud.spring.boot;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.tencentcloud.spring.boot.trtc.TencentTrtcTemplate;
import com.tencentcloud.spring.boot.trtc.TrtcUserIdProvider;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.trtc.v20190722.TrtcClient;

@Configuration
@ConditionalOnClass(TrtcClient.class)
@ConditionalOnProperty(prefix = TencentTrtcProperties.PREFIX, value = "enabled", havingValue = "true")
@EnableConfigurationProperties({ TencentCloudProperties.class, TencentTrtcProperties.class })
public class TencentTrtcAutoConfiguration {

	/*
	 * 1、实例化 Trtc 的 client 对象 第二个参数是地域信息，可以直接填写字符串 ap-guangzhou，或者引用预设的常量
	 */
	@Bean
	public TrtcClient trtcClient(TencentCloudProperties cloudProperties, TencentTrtcProperties trtcProperties) {
		
		/*
		 * 实例化一个认证对象，入参需要传入腾讯云账户密钥对 secretId 和 secretKey
		 * 密钥查询：https://console.cloud.tencent.com/cam/capi
		 */
		String secretId = StringUtils.hasText(trtcProperties.getSecretId()) ? trtcProperties.getSecretId() : cloudProperties.getSecretId();
		String secretKey = StringUtils.hasText(trtcProperties.getSecretKey()) ? trtcProperties.getSecretKey() : cloudProperties.getSecretKey();
		Credential credential = new Credential(secretId, secretKey);

        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setSignMethod(trtcProperties.getSignMethod()); // 指定签名算法(默认为HmacSHA256)
        // 自3.1.80版本开始，SDK 支持打印日志。
        clientProfile.setHttpProfile(trtcProperties.getHttpProfile());
        clientProfile.setDebug(cloudProperties.isDebug());
        // 从3.1.16版本开始，支持设置公共参数 Language, 默认不传，选择(ZH_CN or EN_US)
        clientProfile.setLanguage(trtcProperties.getLanguage());
        
		return new TrtcClient(credential, trtcProperties.getRegion(), clientProfile);
	}
	
	@Bean
	@ConditionalOnBean(TrtcClient.class)
	public TencentTrtcTemplate tencentTrtcTemplate(TrtcClient trtcClient, TencentTrtcProperties properties,
			ObjectProvider<TrtcUserIdProvider> trtcUserIdProvider) {
		return new TencentTrtcTemplate(trtcClient, properties, trtcUserIdProvider.getIfAvailable(() -> {
			return new TrtcUserIdProvider() {};
		}));
	}

}
