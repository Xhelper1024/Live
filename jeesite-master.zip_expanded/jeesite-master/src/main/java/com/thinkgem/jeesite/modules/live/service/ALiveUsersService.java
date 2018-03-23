/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.live.entity.ALiveUsers;
import com.thinkgem.jeesite.modules.live.dao.ALiveUsersDao;

/**
 * 用户Service
 * @author 谢辉
 * @version 2018-01-28
 */
@Service
@Transactional(readOnly = true)
public class ALiveUsersService extends CrudService<ALiveUsersDao, ALiveUsers> {

	public ALiveUsers get(String id) {
		return super.get(id);
	}
	
	public List<ALiveUsers> findList(ALiveUsers aLiveUsers) {
		return super.findList(aLiveUsers);
	}
	
	public Page<ALiveUsers> findPage(Page<ALiveUsers> page, ALiveUsers aLiveUsers) {
		return super.findPage(page, aLiveUsers);
	}
	
	@Transactional(readOnly = false)
	public void save(ALiveUsers aLiveUsers) {
		super.save(aLiveUsers);
	}
	
	@Transactional(readOnly = false)
	public void delete(ALiveUsers aLiveUsers) {
		super.delete(aLiveUsers);
	}
	
}