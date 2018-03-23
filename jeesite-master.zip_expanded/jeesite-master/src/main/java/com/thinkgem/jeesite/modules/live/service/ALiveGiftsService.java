/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.live.entity.ALiveGifts;
import com.thinkgem.jeesite.modules.live.dao.ALiveGiftsDao;

/**
 * 直播礼物Service
 * @author 谢辉
 * @version 2018-01-28
 */
@Service
@Transactional(readOnly = true)
public class ALiveGiftsService extends CrudService<ALiveGiftsDao, ALiveGifts> {

	public ALiveGifts get(String id) {
		return super.get(id);
	}
	
	public List<ALiveGifts> findList(ALiveGifts aLiveGifts) {
		return super.findList(aLiveGifts);
	}
	
	public Page<ALiveGifts> findPage(Page<ALiveGifts> page, ALiveGifts aLiveGifts) {
		return super.findPage(page, aLiveGifts);
	}
	
	@Transactional(readOnly = false)
	public void save(ALiveGifts aLiveGifts) {
		super.save(aLiveGifts);
	}
	
	@Transactional(readOnly = false)
	public void delete(ALiveGifts aLiveGifts) {
		super.delete(aLiveGifts);
	}
	
}