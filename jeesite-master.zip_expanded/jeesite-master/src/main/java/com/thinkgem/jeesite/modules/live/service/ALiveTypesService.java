/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.live.entity.ALiveTypes;
import com.thinkgem.jeesite.modules.live.dao.ALiveTypesDao;

/**
 * 直播类型Service
 * @author 谢辉
 * @version 2018-01-28
 */
@Service
@Transactional(readOnly = true)
public class ALiveTypesService extends CrudService<ALiveTypesDao, ALiveTypes> {

	public ALiveTypes get(String id) {
		return super.get(id);
	}
	
	public List<ALiveTypes> findList(ALiveTypes aLiveTypes) {
		return super.findList(aLiveTypes);
	}
	
	public Page<ALiveTypes> findPage(Page<ALiveTypes> page, ALiveTypes aLiveTypes) {
		return super.findPage(page, aLiveTypes);
	}
	
	@Transactional(readOnly = false)
	public void save(ALiveTypes aLiveTypes) {
		super.save(aLiveTypes);
	}
	
	@Transactional(readOnly = false)
	public void delete(ALiveTypes aLiveTypes) {
		super.delete(aLiveTypes);
	}
	
}