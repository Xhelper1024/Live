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
import com.thinkgem.jeesite.modules.live.entity.ALiveGifts;
import com.thinkgem.jeesite.modules.live.service.ALiveGiftsService;

/**
 * 直播礼物Controller
 * @author 谢辉
 * @version 2018-01-28
 */
@Controller
@RequestMapping(value = "${adminPath}/live/aLiveGifts")
public class ALiveGiftsController extends BaseController {

	@Autowired
	private ALiveGiftsService aLiveGiftsService;
	
	@ModelAttribute
	public ALiveGifts get(@RequestParam(required=false) String id) {
		ALiveGifts entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = aLiveGiftsService.get(id);
		}
		if (entity == null){
			entity = new ALiveGifts();
		}
		return entity;
	}
	
	@RequiresPermissions("live:aLiveGifts:view")
	@RequestMapping(value = {"list", ""})
	public String list(ALiveGifts aLiveGifts, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ALiveGifts> page = aLiveGiftsService.findPage(new Page<ALiveGifts>(request, response), aLiveGifts); 
		model.addAttribute("page", page);
		model.addAttribute("aLiveGifts", aLiveGifts);
		return "modules/live/aLiveGiftsList";
	}

	@RequiresPermissions("live:aLiveGifts:view")
	@RequestMapping(value = "form")
	public String form(ALiveGifts aLiveGifts, Model model) {
		model.addAttribute("aLiveGifts", aLiveGifts);
		return "modules/live/aLiveGiftsForm";
	}

	@RequiresPermissions("live:aLiveGifts:edit")
	@RequestMapping(value = "save")
	public String save(ALiveGifts aLiveGifts, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, aLiveGifts)){
			return form(aLiveGifts, model);
		}
		aLiveGiftsService.save(aLiveGifts);
		addMessage(redirectAttributes, "保存直播礼物成功");
		return "redirect:"+Global.getAdminPath()+"/live/aLiveGifts/?repage";
	}
	
	@RequiresPermissions("live:aLiveGifts:edit")
	@RequestMapping(value = "delete")
	public String delete(ALiveGifts aLiveGifts, RedirectAttributes redirectAttributes) {
		aLiveGiftsService.delete(aLiveGifts);
		addMessage(redirectAttributes, "删除直播礼物成功");
		return "redirect:"+Global.getAdminPath()+"/live/aLiveGifts/?repage";
	}

}