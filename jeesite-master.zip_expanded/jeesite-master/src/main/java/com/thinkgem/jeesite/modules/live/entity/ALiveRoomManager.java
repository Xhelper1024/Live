/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 房间管理Entity
 * @author 谢辉
 * @version 2018-01-28
 */
public class ALiveRoomManager extends DataEntity<ALiveRoomManager> {
	
	private static final long serialVersionUID = 1L;
	private String userId;		// 用户id
	private String roomId;		// 房间id
	
	public ALiveRoomManager() {
		super();
	}

	public ALiveRoomManager(String id){
		super(id);
	}

	@Length(min=0, max=11, message="用户id长度必须介于 0 和 11 之间")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Length(min=0, max=11, message="房间id长度必须介于 0 和 11 之间")
	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	
}