/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.live.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.live.entity.ALiveHistory;
import com.thinkgem.jeesite.modules.live.service.ALiveHistoryService;

/**
 * 历史记录Controller
 * @author 谢辉
 * @version 2018-01-28
 */
@Controller
@RequestMapping(value = "${adminPath}/live/aLiveHistory")
public class ALiveHistoryController extends BaseController {

	@Autowired
	private ALiveHistoryService aLiveHistoryService;
	
	@ModelAttribute
	public ALiveHistory get(@RequestParam(required=false) String id) {
		ALiveHistory entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = aLiveHistoryService.get(id);
		}
		if (entity == null){
			entity = new ALiveHistory();
		}
		return entity;
	}
	
	@RequiresPermissions("live:aLiveHistory:view")
	@RequestMapping(value = {"list", ""})
	public String list(ALiveHistory aLiveHistory, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ALiveHistory> page = aLiveHistoryService.findPage(new Page<ALiveHistory>(request, response), aLiveHistory); 
		model.addAttribute("page", page);
		model.addAttribute("aLiveHistory", aLiveHistory);
		return "modules/live/aLiveHistoryList";
	}

	@RequiresPermissions("live:aLiveHistory:view")
	@RequestMapping(value = "form")
	public String form(ALiveHistory aLiveHistory, Model model) {
		model.addAttribute("aLiveHistory", aLiveHistory);
		return "modules/live/aLiveHistoryForm";
	}

	@RequiresPermissions("live:aLiveHistory:edit")
	@RequestMapping(value = "save")
	public String save(ALiveHistory aLiveHistory, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, aLiveHistory)){
			return form(aLiveHistory, model);
		}
		aLiveHistoryService.save(aLiveHistory);
		addMessage(redirectAttributes, "保存历史记录成功");
		return "redirect:"+Global.getAdminPath()+"/live/aLiveHistory/?repage";
	}
	
	@RequiresPermissions("live:aLiveHistory:edit")
	@RequestMapping(value = "delete")
	public String delete(ALiveHistory aLiveHistory, RedirectAttributes redirectAttributes) {
		aLiveHistoryService.delete(aLiveHistory);
		addMessage(redirectAttributes, "删除历史记录成功");
		return "redirect:"+Global.getAdminPath()+"/live/aLiveHistory/?repage";
	}

}