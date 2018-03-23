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
import com.thinkgem.jeesite.modules.live.entity.ALiveRoomShutdown;
import com.thinkgem.jeesite.modules.live.service.ALiveRoomShutdownService;

/**
 * 房间禁言Controller
 * @author 谢辉
 * @version 2018-01-28
 */
@Controller
@RequestMapping(value = "${adminPath}/live/aLiveRoomShutdown")
public class ALiveRoomShutdownController extends BaseController {

	@Autowired
	private ALiveRoomShutdownService aLiveRoomShutdownService;
	
	@ModelAttribute
	public ALiveRoomShutdown get(@RequestParam(required=false) String id) {
		ALiveRoomShutdown entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = aLiveRoomShutdownService.get(id);
		}
		if (entity == null){
			entity = new ALiveRoomShutdown();
		}
		return entity;
	}
	
	@RequiresPermissions("live:aLiveRoomShutdown:view")
	@RequestMapping(value = {"list", ""})
	public String list(ALiveRoomShutdown aLiveRoomShutdown, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ALiveRoomShutdown> page = aLiveRoomShutdownService.findPage(new Page<ALiveRoomShutdown>(request, response), aLiveRoomShutdown); 
		model.addAttribute("page", page);
		model.addAttribute("aLiveRoomShutdown", aLiveRoomShutdown);
		return "modules/live/aLiveRoomShutdownList";
	}

	@RequiresPermissions("live:aLiveRoomShutdown:view")
	@RequestMapping(value = "form")
	public String form(ALiveRoomShutdown aLiveRoomShutdown, Model model) {
		model.addAttribute("aLiveRoomShutdown", aLiveRoomShutdown);
		return "modules/live/aLiveRoomShutdownForm";
	}

	@RequiresPermissions("live:aLiveRoomShutdown:edit")
	@RequestMapping(value = "save")
	public String save(ALiveRoomShutdown aLiveRoomShutdown, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, aLiveRoomShutdown)){
			return form(aLiveRoomShutdown, model);
		}
		aLiveRoomShutdownService.save(aLiveRoomShutdown);
		addMessage(redirectAttributes, "保存房间禁言成功");
		return "redirect:"+Global.getAdminPath()+"/live/aLiveRoomShutdown/?repage";
	}
	
	@RequiresPermissions("live:aLiveRoomShutdown:edit")
	@RequestMapping(value = "delete")
	public String delete(ALiveRoomShutdown aLiveRoomShutdown, RedirectAttributes redirectAttributes) {
		aLiveRoomShutdownService.delete(aLiveRoomShutdown);
		addMessage(redirectAttributes, "删除房间禁言成功");
		return "redirect:"+Global.getAdminPath()+"/live/aLiveRoomShutdown/?repage";
	}

}