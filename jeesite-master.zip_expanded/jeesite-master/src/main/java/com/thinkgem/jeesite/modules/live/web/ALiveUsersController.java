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
import com.thinkgem.jeesite.modules.live.entity.ALiveUsers;
import com.thinkgem.jeesite.modules.live.service.ALiveUsersService;

/**
 * 用户Controller
 * @author 谢辉
 * @version 2018-01-28
 */
@Controller
@RequestMapping(value = "${adminPath}/live/aLiveUsers")
public class ALiveUsersController extends BaseController {

	@Autowired
	private ALiveUsersService aLiveUsersService;
	
	@ModelAttribute
	public ALiveUsers get(@RequestParam(required=false) String id) {
		ALiveUsers entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = aLiveUsersService.get(id);
		}
		if (entity == null){
			entity = new ALiveUsers();
		}
		return entity;
	}
	
	@RequiresPermissions("live:aLiveUsers:view")
	@RequestMapping(value = {"list", ""})
	public String list(ALiveUsers aLiveUsers, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ALiveUsers> page = aLiveUsersService.findPage(new Page<ALiveUsers>(request, response), aLiveUsers); 
		model.addAttribute("page", page);
		model.addAttribute("aLiveUsers", aLiveUsers);
		return "modules/live/aLiveUsersList";
	}

	@RequiresPermissions("live:aLiveUsers:view")
	@RequestMapping(value = "form")
	public String form(ALiveUsers aLiveUsers, Model model) {
		model.addAttribute("aLiveUsers", aLiveUsers);
		return "modules/live/aLiveUsersForm";
	}

	@RequiresPermissions("live:aLiveUsers:edit")
	@RequestMapping(value = "save")
	public String save(ALiveUsers aLiveUsers, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, aLiveUsers)){
			return form(aLiveUsers, model);
		}
		aLiveUsersService.save(aLiveUsers);
		addMessage(redirectAttributes, "保存用户成功");
		return "redirect:"+Global.getAdminPath()+"/live/aLiveUsers/?repage";
	}
	
	@RequiresPermissions("live:aLiveUsers:edit")
	@RequestMapping(value = "delete")
	public String delete(ALiveUsers aLiveUsers, RedirectAttributes redirectAttributes) {
		aLiveUsersService.delete(aLiveUsers);
		addMessage(redirectAttributes, "删除用户成功");
		return "redirect:"+Global.getAdminPath()+"/live/aLiveUsers/?repage";
	}

}