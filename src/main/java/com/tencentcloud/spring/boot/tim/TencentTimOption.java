package com.tencentcloud.spring.boot.tim;

import lombok.Data;

@Data
public class TencentTimOption {

    public static final String ADMINISTRATOR = "administrator";
    // 单位秒
    private static final long EXPIRE = 86400 * 30;

    /**
     * 帐号管理员
     */
    private String identifier = ADMINISTRATOR;

    /**
     * SDKAppID
     */
    private Long sdkappid;

    /**
     * 密钥
     */
    private String privateKey;

    /**
     * 签名过期时间，单位秒
     */
    private long expire = EXPIRE;

    /**
     * 消息离线保存时长（单位：秒），最长为7天（604800秒）
     * 若设置该字段为0，则消息只发在线用户，不保存离线
     * 若设置该字段超过7天（604800秒），仍只保存7天
     * 若不设置该字段，则默认保存7天
     */
    private long msgLifeTime = 604800;

}
