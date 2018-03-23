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
import com.thinkgem.jeesite.modules.live.entity.ALiveRooms;
import com.thinkgem.jeesite.modules.live.service.ALiveRoomsService;

/**
 * 直播房间Controller
 * @author 谢辉
 * @version 2018-01-28
 */
@Controller
@RequestMapping(value = "${adminPath}/live/aLiveRooms")
public class ALiveRoomsController extends BaseController {

	@Autowired
	private ALiveRoomsService aLiveRoomsService;
	
	@ModelAttribute
	public ALiveRooms get(@RequestParam(required=false) String id) {
		ALiveRooms entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = aLiveRoomsService.get(id);
		}
		if (entity == null){
			entity = new ALiveRooms();
		}
		return entity;
	}
	
	@RequiresPermissions("live:aLiveRooms:view")
	@RequestMapping(value = {"list", ""})
	public String list(ALiveRooms aLiveRooms, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ALiveRooms> page = aLiveRoomsService.findPage(new Page<ALiveRooms>(request, response), aLiveRooms); 
		model.addAttribute("page", page);
		model.addAttribute("aLiveRooms", aLiveRooms);
		return "modules/live/aLiveRoomsList";
	}

	@RequiresPermissions("live:aLiveRooms:view")
	@RequestMapping(value = "form")
	public String form(ALiveRooms aLiveRooms, Model model) {
		model.addAttribute("aLiveRooms", aLiveRooms);
		return "modules/live/aLiveRoomsForm";
	}

	@RequiresPermissions("live:aLiveRooms:edit")
	@RequestMapping(value = "save")
	public String save(ALiveRooms aLiveRooms, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, aLiveRooms)){
			return form(aLiveRooms, model);
		}
		aLiveRoomsService.save(aLiveRooms);
		addMessage(redirectAttributes, "保存直播房间成功");
		return "redirect:"+Global.getAdminPath()+"/live/aLiveRooms/?repage";
	}
	
	@RequiresPermissions("live:aLiveRooms:edit")
	@RequestMapping(value = "delete")
	public String delete(ALiveRooms aLiveRooms, RedirectAttributes redirectAttributes) {
		aLiveRoomsService.delete(aLiveRooms);
		addMessage(redirectAttributes, "删除直播房间成功");
		return "redirect:"+Global.getAdminPath()+"/live/aLiveRooms/?repage";
	}

}