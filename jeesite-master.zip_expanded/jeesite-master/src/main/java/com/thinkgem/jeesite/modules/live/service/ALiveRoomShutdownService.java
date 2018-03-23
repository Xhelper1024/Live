/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.live.entity.ALiveRoomShutdown;
import com.thinkgem.jeesite.modules.live.dao.ALiveRoomShutdownDao;

/**
 * 房间禁言Service
 * @author 谢辉
 * @version 2018-01-28
 */
@Service
@Transactional(readOnly = true)
public class ALiveRoomShutdownService extends CrudService<ALiveRoomShutdownDao, ALiveRoomShutdown> {

	public ALiveRoomShutdown get(String id) {
		return super.get(id);
	}
	
	public List<ALiveRoomShutdown> findList(ALiveRoomShutdown aLiveRoomShutdown) {
		return super.findList(aLiveRoomShutdown);
	}
	
	public Page<ALiveRoomShutdown> findPage(Page<ALiveRoomShutdown> page, ALiveRoomShutdown aLiveRoomShutdown) {
		return super.findPage(page, aLiveRoomShutdown);
	}
	
	@Transactional(readOnly = false)
	public void save(ALiveRoomShutdown aLiveRoomShutdown) {
		super.save(aLiveRoomShutdown);
	}
	
	@Transactional(readOnly = false)
	public void delete(ALiveRoomShutdown aLiveRoomShutdown) {
		super.delete(aLiveRoomShutdown);
	}
	
}