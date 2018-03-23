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
import com.thinkgem.jeesite.modules.live.entity.ALiveRoomManager;
import com.thinkgem.jeesite.modules.live.service.ALiveRoomManagerService;

/**
 * 房间管理Controller
 * @author 谢辉
 * @version 2018-01-28
 */
@Controller
@RequestMapping(value = "${adminPath}/live/aLiveRoomManager")
public class ALiveRoomManagerController extends BaseController {

	@Autowired
	private ALiveRoomManagerService aLiveRoomManagerService;
	
	@ModelAttribute
	public ALiveRoomManager get(@RequestParam(required=false) String id) {
		ALiveRoomManager entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = aLiveRoomManagerService.get(id);
		}
		if (entity == null){
			entity = new ALiveRoomManager();
		}
		return entity;
	}
	
	@RequiresPermissions("live:aLiveRoomManager:view")
	@RequestMapping(value = {"list", ""})
	public String list(ALiveRoomManager aLiveRoomManager, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ALiveRoomManager> page = aLiveRoomManagerService.findPage(new Page<ALiveRoomManager>(request, response), aLiveRoomManager); 
		model.addAttribute("page", page);
		model.addAttribute("aLiveRoomManager", aLiveRoomManager);
		return "modules/live/aLiveRoomManagerList";
	}

	@RequiresPermissions("live:aLiveRoomManager:view")
	@RequestMapping(value = "form")
	public String form(ALiveRoomManager aLiveRoomManager, Model model) {
		model.addAttribute("aLiveRoomManager", aLiveRoomManager);
		return "modules/live/aLiveRoomManagerForm";
	}

	@RequiresPermissions("live:aLiveRoomManager:edit")
	@RequestMapping(value = "save")
	public String save(ALiveRoomManager aLiveRoomManager, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, aLiveRoomManager)){
			return form(aLiveRoomManager, model);
		}
		aLiveRoomManagerService.save(aLiveRoomManager);
		addMessage(redirectAttributes, "保存房间管理成功");
		return "redirect:"+Global.getAdminPath()+"/live/aLiveRoomManager/?repage";
	}
	
	@RequiresPermissions("live:aLiveRoomManager:edit")
	@RequestMapping(value = "delete")
	public String delete(ALiveRoomManager aLiveRoomManager, RedirectAttributes redirectAttributes) {
		aLiveRoomManagerService.delete(aLiveRoomManager);
		addMessage(redirectAttributes, "删除房间管理成功");
		return "redirect:"+Global.getAdminPath()+"/live/aLiveRoomManager/?repage";
	}

}