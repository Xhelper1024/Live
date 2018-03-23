/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.live.entity.ALiveResvGifts;
import com.thinkgem.jeesite.modules.live.dao.ALiveResvGiftsDao;

/**
 * 礼物收益Service
 * @author 谢辉
 * @version 2018-01-28
 */
@Service
@Transactional(readOnly = true)
public class ALiveResvGiftsService extends CrudService<ALiveResvGiftsDao, ALiveResvGifts> {

	public ALiveResvGifts get(String id) {
		return super.get(id);
	}
	
	public List<ALiveResvGifts> findList(ALiveResvGifts aLiveResvGifts) {
		return super.findList(aLiveResvGifts);
	}
	
	public Page<ALiveResvGifts> findPage(Page<ALiveResvGifts> page, ALiveResvGifts aLiveResvGifts) {
		return super.findPage(page, aLiveResvGifts);
	}
	
	@Transactional(readOnly = false)
	public void save(ALiveResvGifts aLiveResvGifts) {
		super.save(aLiveResvGifts);
	}
	
	@Transactional(readOnly = false)
	public void delete(ALiveResvGifts aLiveResvGifts) {
		super.delete(aLiveResvGifts);
	}
	
}