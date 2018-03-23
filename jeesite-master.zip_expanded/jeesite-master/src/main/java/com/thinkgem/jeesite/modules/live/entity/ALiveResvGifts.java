/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 礼物收益Entity
 * @author 谢辉
 * @version 2018-01-28
 */
public class ALiveResvGifts extends DataEntity<ALiveResvGifts> {
	
	private static final long serialVersionUID = 1L;
	private String userId;		// 用户id
	private String roomId;		// 房间id
	private String giftId;		// 礼物id
	private String number;		// 数量
	
	public ALiveResvGifts() {
		super();
	}

	public ALiveResvGifts(String id){
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
	
	@Length(min=0, max=11, message="礼物id长度必须介于 0 和 11 之间")
	public String getGiftId() {
		return giftId;
	}

	public void setGiftId(String giftId) {
		this.giftId = giftId;
	}
	
	@Length(min=0, max=11, message="数量长度必须介于 0 和 11 之间")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}