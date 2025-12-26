package com.tencentcloud.spring.boot;

import com.tencentcloud.spring.boot.tim.TencentTimOption;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tencentcloud.spring.boot.tim.TencentTimTemplate;
import com.tencentcloud.spring.boot.tim.TimInfoProvider;
import com.tencentcloud.spring.boot.tim.resp.account.AccountKickResponse;

import okhttp3.OkHttpClient;

public class TencentTim_Test {

	ObjectMapper objectMapper = new ObjectMapper();
	OkHttpClient okhttp3Client = new OkHttpClient.Builder().build();
	TencentTimProperties properties = new TencentTimProperties();

	@Before
	public void setup() {
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		properties.setSdkappid(1400288577L);
		properties.setPrivateKey("");
	}

	@Test
	public void testKick() {

		try {
			
			TencentTimTemplate template = new TencentTimTemplate(properties, okhttp3Client, new TimInfoProvider() {
				@Override
				public TencentTimOption getTimOptionBySdkAppId(Long sdkAppId) {
					return null;
				}
			});
			AccountKickResponse response =  template.opsForAccount().kickout("administrator");
			System.out.println(objectMapper.writeValueAsString(response));
			
			template.opsForAccount().delete(new String[] {"111"});
			template.opsForProfile().portraitGet("111");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}