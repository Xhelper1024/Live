/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 直播房间Entity
 * @author 谢辉
 * @version 2018-01-28
 */
public class ALiveRooms extends DataEntity<ALiveRooms> {
	
	private static final long serialVersionUID = 1L;
	private String userId;		// 主播id
	private String liveTypeId;		// 直播类型id
	private String roomName;		// 房间名
	private String roomState;		// 房间状态
	
	public ALiveRooms() {
		super();
	}

	public ALiveRooms(String id){
		super(id);
	}

	@Length(min=0, max=11, message="主播id长度必须介于 0 和 11 之间")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Length(min=0, max=11, message="直播类型id长度必须介于 0 和 11 之间")
	public String getLiveTypeId() {
		return liveTypeId;
	}

	public void setLiveTypeId(String liveTypeId) {
		this.liveTypeId = liveTypeId;
	}
	
	@Length(min=0, max=255, message="房间名长度必须介于 0 和 255 之间")
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	@Length(min=0, max=255, message="房间状态长度必须介于 0 和 255 之间")
	public String getRoomState() {
		return roomState;
	}

	public void setRoomState(String roomState) {
		this.roomState = roomState;
	}
	
}