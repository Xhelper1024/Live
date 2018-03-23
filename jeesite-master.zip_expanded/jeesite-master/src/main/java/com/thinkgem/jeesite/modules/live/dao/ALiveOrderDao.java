/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.live.entity.ALiveOrder;

/**
 * 充值订单DAO接口
 * @author 谢辉
 * @version 2018-01-28
 */
@MyBatisDao
public interface ALiveOrderDao extends CrudDao<ALiveOrder> {
	
}