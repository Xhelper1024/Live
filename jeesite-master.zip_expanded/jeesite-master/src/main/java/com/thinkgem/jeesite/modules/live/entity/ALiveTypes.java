/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 直播类型Entity
 * @author 谢辉
 * @version 2018-01-28
 */
public class ALiveTypes extends DataEntity<ALiveTypes> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 类型名称
	
	public ALiveTypes() {
		super();
	}

	public ALiveTypes(String id){
		super(id);
	}

	@Length(min=0, max=255, message="类型名称长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}