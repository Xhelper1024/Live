/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.live.entity.ALiveFollow;
import com.thinkgem.jeesite.modules.live.dao.ALiveFollowDao;

/**
 * 直播订阅Service
 * @author 谢辉
 * @version 2018-01-28
 */
@Service
@Transactional(readOnly = true)
public class ALiveFollowService extends CrudService<ALiveFollowDao, ALiveFollow> {

	public ALiveFollow get(String id) {
		return super.get(id);
	}
	
	public List<ALiveFollow> findList(ALiveFollow aLiveFollow) {
		return super.findList(aLiveFollow);
	}
	
	public Page<ALiveFollow> findPage(Page<ALiveFollow> page, ALiveFollow aLiveFollow) {
		return super.findPage(page, aLiveFollow);
	}
	
	@Transactional(readOnly = false)
	public void save(ALiveFollow aLiveFollow) {
		super.save(aLiveFollow);
	}
	
	@Transactional(readOnly = false)
	public void delete(ALiveFollow aLiveFollow) {
		super.delete(aLiveFollow);
	}
	
}