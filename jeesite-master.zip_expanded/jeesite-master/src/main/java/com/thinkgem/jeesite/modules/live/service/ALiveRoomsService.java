/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.live.entity.ALiveRooms;
import com.thinkgem.jeesite.modules.live.dao.ALiveRoomsDao;

/**
 * 直播房间Service
 * @author 谢辉
 * @version 2018-01-28
 */
@Service
@Transactional(readOnly = true)
public class ALiveRoomsService extends CrudService<ALiveRoomsDao, ALiveRooms> {

	public ALiveRooms get(String id) {
		return super.get(id);
	}
	
	public List<ALiveRooms> findList(ALiveRooms aLiveRooms) {
		return super.findList(aLiveRooms);
	}
	
	public Page<ALiveRooms> findPage(Page<ALiveRooms> page, ALiveRooms aLiveRooms) {
		return super.findPage(page, aLiveRooms);
	}
	
	@Transactional(readOnly = false)
	public void save(ALiveRooms aLiveRooms) {
		super.save(aLiveRooms);
	}
	
	@Transactional(readOnly = false)
	public void delete(ALiveRooms aLiveRooms) {
		super.delete(aLiveRooms);
	}
	
}