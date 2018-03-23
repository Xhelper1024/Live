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
import com.thinkgem.jeesite.modules.live.entity.ALiveTypes;
import com.thinkgem.jeesite.modules.live.service.ALiveTypesService;

/**
 * 直播类型Controller
 * @author 谢辉
 * @version 2018-01-28
 */
@Controller
@RequestMapping(value = "${adminPath}/live/aLiveTypes")
public class ALiveTypesController extends BaseController {

	@Autowired
	private ALiveTypesService aLiveTypesService;
	
	@ModelAttribute
	public ALiveTypes get(@RequestParam(required=false) String id) {
		ALiveTypes entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = aLiveTypesService.get(id);
		}
		if (entity == null){
			entity = new ALiveTypes();
		}
		return entity;
	}
	
	@RequiresPermissions("live:aLiveTypes:view")
	@RequestMapping(value = {"list", ""})
	public String list(ALiveTypes aLiveTypes, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ALiveTypes> page = aLiveTypesService.findPage(new Page<ALiveTypes>(request, response), aLiveTypes); 
		model.addAttribute("page", page);
		model.addAttribute("aLiveTypes", aLiveTypes);
		return "modules/live/aLiveTypesList";
	}

	@RequiresPermissions("live:aLiveTypes:view")
	@RequestMapping(value = "form")
	public String form(ALiveTypes aLiveTypes, Model model) {
		model.addAttribute("aLiveTypes", aLiveTypes);
		return "modules/live/aLiveTypesForm";
	}

	@RequiresPermissions("live:aLiveTypes:edit")
	@RequestMapping(value = "save")
	public String save(ALiveTypes aLiveTypes, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, aLiveTypes)){
			return form(aLiveTypes, model);
		}
		aLiveTypesService.save(aLiveTypes);
		addMessage(redirectAttributes, "保存直播类型成功");
		return "redirect:"+Global.getAdminPath()+"/live/aLiveTypes/?repage";
	}
	
	@RequiresPermissions("live:aLiveTypes:edit")
	@RequestMapping(value = "delete")
	public String delete(ALiveTypes aLiveTypes, RedirectAttributes redirectAttributes) {
		aLiveTypesService.delete(aLiveTypes);
		addMessage(redirectAttributes, "删除直播类型成功");
		return "redirect:"+Global.getAdminPath()+"/live/aLiveTypes/?repage";
	}

}