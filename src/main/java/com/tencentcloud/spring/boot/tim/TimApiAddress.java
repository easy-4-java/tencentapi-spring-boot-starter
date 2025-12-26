package com.tencentcloud.spring.boot.tim;

/**
 * https://cloud.tencent.com/document/product/269/1520
 * @author 		： <a href="https://github.com/hiwepy">hiwepy</a>
 */
public enum TimApiAddress {
	
	// ---------------- 帐号管理 ------------------
	
	/**
	 * 导入单个帐号
	 */
	ACCOUNT_IMPORT("导入单个帐号", "https://console.tim.qq.com/v4/im_open_login_svc/account_import"),
	/**
	 * 导入多个帐号 
	 */
	MULTI_ACCOUNT_IMPORT("导入多个帐号", "https://console.tim.qq.com/v4/im_open_login_svc/multiaccount_import"),
	/**
	 * 删除帐号
	 */
	ACCOUNT_DELETE("删除帐号", "https://console.tim.qq.com/v4/im_open_login_svc/account_delete"),
	/**
	 * 查询帐号
	 */
	ACCOUNT_CHECK("查询帐号", "https://console.tim.qq.com/v4/im_open_login_svc/account_check"),
	/**
	 * 失效帐号登录态
	 */
	ACCOUNT_KICK("失效帐号登录态", "https://console.tim.qq.com/v4/im_open_login_svc/kick"),
	/**
	 * 查询帐号在线状态
	 */
	ACCOUNT_STATE("查询帐号在线状态", "https://console.tim.qq.com/v4/openim/querystate"),
	
	// ---------------- 单聊消息 ------------------
	
	/**
	 * 单发单聊消息
	 */
	SEND_MSG("单发单聊消息", "https://console.tim.qq.com/v4/openim/sendmsg"),
	/**
	 * 批量发单聊消息
	 */
	SEND_BATCH_MSG("批量发单聊消息", "https://console.tim.qq.com/v4/openim/batchsendmsg"),
	/**
	 * 导入单聊消息
	 */
	IMPORT_MSG("导入单聊消息", "https://console.tim.qq.com/v4/openim/importmsg"),
	/**
	 * 查询单聊消息
	 */
	ADMIN_GET_ROAMMSG("查询单聊消息", "https://console.tim.qq.com/v4/openim/admin_getroammsg"),
	/**
	 * 撤回单聊消息
	 */
	ADMIN_MSG_WITHDRAW("撤回单聊消息", "https://console.tim.qq.com/v4/openim/admin_msgwithdraw"),
	/**
	 * 设置单聊消息已读
	 */
	ADMIN_SET_MSG_READ("设置单聊消息已读", "https://console.tim.qq.com/v4/openim/admin_set_msg_read"),
	
	// ---------------- 全员推送 ------------------
	
	/**
	 * 全员推送
	 */
	IM_PUSH("全员推送", "https://console.tim.qq.com/v4/all_member_push/im_push"),
	/**
	 * 设置应用属性名称
	 */
	IM_SET_ATTR_NAME("设置应用属性名称", "https://console.tim.qq.com/v4/all_member_push/im_set_attr_name"),
	/**
	 * 获取应用属性名称
	 */
	IM_GET_ATTR_NAME("获取应用属性名称", "https://console.tim.qq.com/v4/all_member_push/im_get_attr_name"),
	/**
	 * 获取用户属性
	 */
	IM_GET_ATTR("获取用户属性", "https://console.tim.qq.com/v4/all_member_push/im_get_attr"),
	/**
	 * 设置用户属性
	 */
	IM_SET_ATTR("设置用户属性", "https://console.tim.qq.com/v4/all_member_push/im_set_attr"),
	/**
	 * 删除用户属性
	 */
	IM_REMOVE_ATTR("删除用户属性", "https://console.tim.qq.com/v4/all_member_push/im_remove_attr"),
	/**
	 * 获取用户标签
	 */
	IM_GET_TAG("获取用户标签", "https://console.tim.qq.com/v4/all_member_push/im_get_tag"),
	/**
	 * 添加用户标签
	 */
	IM_ADD_TAG("添加用户标签", "https://console.tim.qq.com/v4/all_member_push/im_add_tag"),
	/**
	 * 删除用户标签
	 */
	IM_REMOVE_TAG("删除用户标签", "https://console.tim.qq.com/v4/all_member_push/im_remove_tag"),
	/**
	 * 删除用户所有标签
	 */
	IM_REMOVE_ALL_TAGS("删除用户所有标签", "https://console.tim.qq.com/v4/all_member_push/im_remove_all_tags"),
	
	// ---------------- 资料管理 ------------------
	
	/**
	 * 拉取资料
	 */
	PORTRAIT_GET("拉取资料", "https://console.tim.qq.com/v4/profile/portrait_get"),
	/**
	 * 设置资料
	 */
	PORTRAIT_SET("设置资料", "https://console.tim.qq.com/v4/profile/portrait_set"),
	
	// ---------------- 关系链管理 ------------------
	
	/**
	 * 添加好友
	 */
	FRIEND_ADD("添加好友", "https://console.tim.qq.com/v4/sns/friend_add"),
	/**
	 * 导入好友
	 */
	FRIEND_IMPORT("导入好友", "https://console.tim.qq.com/v4/sns/friend_import"),
	/**
	 * 更新好友
	 */
	FRIEND_UPDATE("更新好友", "https://console.tim.qq.com/v4/sns/friend_update"),
	/**
	 * 删除好友
	 */
	FRIEND_DELETE("删除好友", "https://console.tim.qq.com/v4/sns/friend_delete"),
	/**
	 * 删除所有好友
	 */
	FRIEND_DELETE_ALL("删除所有好友", "https://console.tim.qq.com/v4/sns/friend_delete_all"),
	/**
	 * 校验好友
	 */
	FRIEND_CHECK("校验好友", "https://console.tim.qq.com/v4/sns/friend_check"),
	/**
	 * 拉取好友
	 */
	FRIEND_GET("拉取好友", "https://console.tim.qq.com/v4/sns/friend_get"),
	/**
	 * 拉取指定好友
	 */
	FRIEND_GET_LIST("拉取指定好友", "https://console.tim.qq.com/v4/sns/friend_get_list"),
	/**
	 * 添加黑名单
	 */
	BLACK_LIST_ADD("添加黑名单", "https://console.tim.qq.com/v4/sns/black_list_add"),
	/**
	 * 删除黑名单
	 */
	BLACK_LIST_DELETE("删除黑名单", "https://console.tim.qq.com/v4/sns/black_list_delete"),
	/**
	 * 拉取黑名单
	 */
	BLACK_LIST_GET("拉取黑名单", "https://console.tim.qq.com/v4/sns/black_list_get"),
	/**
	 * 校验黑名单
	 */
	BLACK_LIST_CHECK("校验黑名单", "https://console.tim.qq.com/v4/sns/black_list_check"),
	/**
	 * 添加分组
	 */
	GROUP_ADD("添加分组", "https://console.tim.qq.com/v4/sns/group_add"),
	/**
	 * 删除分组
	 */
	GROUP_DELETE("删除分组", "https://console.tim.qq.com/v4/sns/group_delete"),
	/**
	 * 拉取分组
	 */
	GROUP_GET("拉取分组", "https://console.tim.qq.com/v4/sns/group_get"),
	
	// ---------------- 群组管理 ------------------
	
	/**
	 * 获取APP中的所有群组
	 */
	GET_APPID_GROUP_LIST("获取APP中的所有群组", "https://console.tim.qq.com/v4/group_open_http_svc/get_appid_group_list"),
	/**
	 * 创建群组
	 */
	CREATE_GROUP("创建群组", "https://console.tim.qq.com/v4/group_open_http_svc/create_group"),
	/**
	 * 获取群组详细资料
	 */
	GET_GROUP_INFO("获取群组详细资料", "https://console.tim.qq.com/v4/group_open_http_svc/get_group_info"),
	/**
	 * 获取群成员详细资料
	 */
	GET_GROUP_MEMBER_INFO("获取群成员详细资料", "https://console.tim.qq.com/v4/group_open_http_svc/get_group_member_info"),
	/**
	 * 修改群基础资料
	 */
	MODIFY_GROUP_BASE_INFO("修改群基础资料", "https://console.tim.qq.com/v4/group_open_http_svc/modify_group_base_info"),
	/**
	 * 增加群组成员
	 */
	ADD_GROUP_MEMBER("增加群成员", "https://console.tim.qq.com/v4/group_open_http_svc/add_group_member"),
	/**
	 * 删除群组成员
	 */
	DELETE_GROUP_MEMBER("删除群组成员", "https://console.tim.qq.com/v4/group_open_http_svc/delete_group_member"),
	/**
	 * 修改群成员资料
	 */
	MODIFY_GROUP_MEMBER_INFO("修改群成员资料", "https://console.tim.qq.com/v4/group_open_http_svc/modify_group_member_info"),
	/**
	 * 解散群组
	 */
	DESTROY_GROUP("解散群组", "https://console.tim.qq.com/v4/group_open_http_svc/destroy_group"),
	/**
	 * 获取用户所加入的群组
	 */
	GET_JOINED_GROUP_LIST("获取用户所加入的群组", "https://console.tim.qq.com/v4/group_open_http_svc/get_joined_group_list"),
	/**
	 * 查询用户在群组中的身份
	 */
	GET_ROLE_IN_GROUP("查询用户在群组中的身份", "https://console.tim.qq.com/v4/group_open_http_svc/get_role_in_group"),
	/**
	 * 批量禁言和取消禁言
	 */
	FORBID_SEND_MSG("批量禁言和取消禁言", "https://console.tim.qq.com/v4/group_open_http_svc/forbid_send_msg"),
	/**
	 * 获取被禁言群成员列表
	 */
	GET_GROUP_SHUTTED_UIN("获取被禁言群成员列表", "https://console.tim.qq.com/v4/group_open_http_svc/get_group_shutted_uin"),
	/**
	 * 在群组中发送普通消息
	 */
	SEND_GROUP_MSG("在群组中发送普通消息", "https://console.tim.qq.com/v4/group_open_http_svc/send_group_msg"),
	/**
	 * 在群组中发送系统通知
	 */
	SEND_GROUP_SYSTEM_NOTIFICATION("在群组中发送系统通知", "https://console.tim.qq.com/v4/group_open_http_svc/send_group_system_notification"),
	/**
	 * 转让群主
	 */
	CHANGE_GROUP_OWNER("转让群主", "https://console.tim.qq.com/v4/group_open_http_svc/change_group_owner"),
	/**
	 *撤回群消息
	 */
	GROUP_MSG_RECALL("撤回群消息", "https://console.tim.qq.com/v4/group_open_http_svc/group_msg_recall"),
	/**
	 * 导入群基础资料
	 */
	IMPORT_GROUP("导入群基础资料", "https://console.tim.qq.com/v4/group_open_http_svc/import_group"),
	/**
	 * 导入群消息
	 */
	IMPORT_GROUP_MSG("导入群消息", "https://console.tim.qq.com/v4/group_open_http_svc/import_group_msg"),
	/**
	 * 导入群成员
	 */
	IMPORT_GROUP_MEMBER("导入群成员", "https://console.tim.qq.com/v4/group_open_http_svc/import_group_member"),
	/**
	 * 设置成员未读消息计数
	 */
	SET_UNREAD_MSG_NUM("设置成员未读消息计数", "https://console.tim.qq.com/v4/group_open_http_svc/set_unread_msg_num"),
	/**
	 * 撤回指定用户发送的消息
	 */
	DELETE_GROUP_MSG_BY_SENDER("撤回指定用户发送的消息", "https://console.tim.qq.com/v4/group_open_http_svc/delete_group_msg_by_sender"),
	/**
	 * 拉取群历史消息
	 */
	GROUP_MSG_GET_SIMPLE("拉取群历史消息", "https://console.tim.qq.com/v4/group_open_http_svc/group_msg_get_simple"),
	/**
	 * 获取直播群在线人数
	 */
	GET_ONLINE_MEMBER_NUM("获取直播群在线人数", "https://console.tim.qq.com/v4/group_open_http_svc/get_online_member_num"),
	
	// ---------------- 全局禁言管理 ------------------

	/**
	 * 设置全局禁言
	 */
	SET_NO_SPEAKING("设置全局禁言", "https://console.tim.qq.com/v4/openconfigsvr/setnospeaking"),
	/**
	 * 查询全局禁言
	 */
	GET_NO_SPEAKING("查询全局禁言", "https://console.tim.qq.com/v4/openconfigsvr/getnospeaking"),
	
	// ---------------- 运营管理 ------------------
	
	/**
	 * 拉取运营数据
	 */
	GET_APP_INFO("拉取运营数据", "https://console.tim.qq.com/v4/openconfigsvr/getappinfo"),
	/**
	 * 下载消息记录
	 */
	GET_HISTORY("下载消息记录", "https://console.tim.qq.com/v4/open_msg_svc/get_history"),
	/**
	 * 获取服务器 IP 地址
	 */
	GET_IP_LIST("获取服务器 IP 地址", "https://console.tim.qq.com/v4/ConfigSvc/GetIPList");

	private String opt;
	private String url;
	private String serviceName;
	private String command;

	
	TimApiAddress(String opt, String url) {
		this.opt = opt;
		this.url = url;
	}

	public String getOpt() {
		return opt;
	}
	
	public String getUrl() {
		return url;
	}
 
}
