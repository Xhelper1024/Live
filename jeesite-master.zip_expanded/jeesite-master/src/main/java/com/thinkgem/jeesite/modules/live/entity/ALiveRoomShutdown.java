/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 房间禁言Entity
 * @author 谢辉
 * @version 2018-01-28
 */
public class ALiveRoomShutdown extends DataEntity<ALiveRoomShutdown> {
	
	private static final long serialVersionUID = 1L;
	private String roomId;		// 房间id
	private String roomManagerId;		// 房管id
	private String shutdownUserId;		// 被禁用户id
	private String shutdownContent;		// 被禁内容
	
	public ALiveRoomShutdown() {
		super();
	}

	public ALiveRoomShutdown(String id){
		super(id);
	}

	@Length(min=0, max=11, message="房间id长度必须介于 0 和 11 之间")
	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	
	@Length(min=0, max=11, message="房管id长度必须介于 0 和 11 之间")
	public String getRoomManagerId() {
		return roomManagerId;
	}

	public void setRoomManagerId(String roomManagerId) {
		this.roomManagerId = roomManagerId;
	}
	
	@Length(min=0, max=11, message="被禁用户id长度必须介于 0 和 11 之间")
	public String getShutdownUserId() {
		return shutdownUserId;
	}

	public void setShutdownUserId(String shutdownUserId) {
		this.shutdownUserId = shutdownUserId;
	}
	
	@Length(min=0, max=255, message="被禁内容长度必须介于 0 和 255 之间")
	public String getShutdownContent() {
		return shutdownContent;
	}

	public void setShutdownContent(String shutdownContent) {
		this.shutdownContent = shutdownContent;
	}
	
}