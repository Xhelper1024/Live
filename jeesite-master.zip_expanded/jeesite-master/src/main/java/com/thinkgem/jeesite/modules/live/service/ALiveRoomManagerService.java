/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.live.entity.ALiveRoomManager;
import com.thinkgem.jeesite.modules.live.dao.ALiveRoomManagerDao;

/**
 * 房间管理Service
 * @author 谢辉
 * @version 2018-01-28
 */
@Service
@Transactional(readOnly = true)
public class ALiveRoomManagerService extends CrudService<ALiveRoomManagerDao, ALiveRoomManager> {

	public ALiveRoomManager get(String id) {
		return super.get(id);
	}
	
	public List<ALiveRoomManager> findList(ALiveRoomManager aLiveRoomManager) {
		return super.findList(aLiveRoomManager);
	}
	
	public Page<ALiveRoomManager> findPage(Page<ALiveRoomManager> page, ALiveRoomManager aLiveRoomManager) {
		return super.findPage(page, aLiveRoomManager);
	}
	
	@Transactional(readOnly = false)
	public void save(ALiveRoomManager aLiveRoomManager) {
		super.save(aLiveRoomManager);
	}
	
	@Transactional(readOnly = false)
	public void delete(ALiveRoomManager aLiveRoomManager) {
		super.delete(aLiveRoomManager);
	}
	
}