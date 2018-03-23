/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.live.entity.ALiveHistory;
import com.thinkgem.jeesite.modules.live.dao.ALiveHistoryDao;

/**
 * 历史记录Service
 * @author 谢辉
 * @version 2018-01-28
 */
@Service
@Transactional(readOnly = true)
public class ALiveHistoryService extends CrudService<ALiveHistoryDao, ALiveHistory> {

	public ALiveHistory get(String id) {
		return super.get(id);
	}
	
	public List<ALiveHistory> findList(ALiveHistory aLiveHistory) {
		return super.findList(aLiveHistory);
	}
	
	public Page<ALiveHistory> findPage(Page<ALiveHistory> page, ALiveHistory aLiveHistory) {
		return super.findPage(page, aLiveHistory);
	}
	
	@Transactional(readOnly = false)
	public void save(ALiveHistory aLiveHistory) {
		super.save(aLiveHistory);
	}
	
	@Transactional(readOnly = false)
	public void delete(ALiveHistory aLiveHistory) {
		super.delete(aLiveHistory);
	}
	
}