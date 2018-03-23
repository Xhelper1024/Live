/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.live.entity.ALiveOrder;
import com.thinkgem.jeesite.modules.live.dao.ALiveOrderDao;

/**
 * 充值订单Service
 * @author 谢辉
 * @version 2018-01-28
 */
@Service
@Transactional(readOnly = true)
public class ALiveOrderService extends CrudService<ALiveOrderDao, ALiveOrder> {

	public ALiveOrder get(String id) {
		return super.get(id);
	}
	
	public List<ALiveOrder> findList(ALiveOrder aLiveOrder) {
		return super.findList(aLiveOrder);
	}
	
	public Page<ALiveOrder> findPage(Page<ALiveOrder> page, ALiveOrder aLiveOrder) {
		return super.findPage(page, aLiveOrder);
	}
	
	@Transactional(readOnly = false)
	public void save(ALiveOrder aLiveOrder) {
		super.save(aLiveOrder);
	}
	
	@Transactional(readOnly = false)
	public void delete(ALiveOrder aLiveOrder) {
		super.delete(aLiveOrder);
	}
	
}