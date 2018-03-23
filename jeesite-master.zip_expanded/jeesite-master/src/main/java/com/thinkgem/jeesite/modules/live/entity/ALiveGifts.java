/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 直播礼物Entity
 * @author 谢辉
 * @version 2018-01-28
 */
public class ALiveGifts extends DataEntity<ALiveGifts> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 礼物名称
	private String price;		// 价格
	private String image;		// 图片
	private String exp;		// 可得经验值
	
	public ALiveGifts() {
		super();
	}

	public ALiveGifts(String id){
		super(id);
	}

	@Length(min=0, max=255, message="礼物名称长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=11, message="价格长度必须介于 0 和 11 之间")
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	@Length(min=0, max=255, message="图片长度必须介于 0 和 255 之间")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	@Length(min=0, max=11, message="可得经验值长度必须介于 0 和 11 之间")
	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}
	
}