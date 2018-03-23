/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 用户Entity
 * @author 谢辉
 * @version 2018-01-28
 */
public class ALiveUsers extends DataEntity<ALiveUsers> {
	
	private static final long serialVersionUID = 1L;
	private String nickname;		// nickname
	private String telephone;		// telephone
	private String password;		// password
	private String headImage;		// head_image
	private String sexy;		// sexy
	private Date birthday;		// birthday
	private String exp;		// exp
	private String gold;		// gold
	private String money;		// money
	private String isStreamer;		// is_streamer
	
	public ALiveUsers() {
		super();
	}

	public ALiveUsers(String id){
		super(id);
	}

	@Length(min=0, max=255, message="nickname长度必须介于 0 和 255 之间")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Length(min=0, max=255, message="telephone长度必须介于 0 和 255 之间")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Length(min=0, max=255, message="password长度必须介于 0 和 255 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=0, max=255, message="head_image长度必须介于 0 和 255 之间")
	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	
	@Length(min=0, max=255, message="sexy长度必须介于 0 和 255 之间")
	public String getSexy() {
		return sexy;
	}

	public void setSexy(String sexy) {
		this.sexy = sexy;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Length(min=0, max=11, message="exp长度必须介于 0 和 11 之间")
	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}
	
	@Length(min=0, max=11, message="gold长度必须介于 0 和 11 之间")
	public String getGold() {
		return gold;
	}

	public void setGold(String gold) {
		this.gold = gold;
	}
	
	@Length(min=0, max=11, message="money长度必须介于 0 和 11 之间")
	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}
	
	@Length(min=0, max=255, message="is_streamer长度必须介于 0 和 255 之间")
	public String getIsStreamer() {
		return isStreamer;
	}

	public void setIsStreamer(String isStreamer) {
		this.isStreamer = isStreamer;
	}
	
}