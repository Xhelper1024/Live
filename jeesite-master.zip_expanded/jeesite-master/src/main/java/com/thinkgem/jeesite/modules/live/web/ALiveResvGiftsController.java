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
import com.thinkgem.jeesite.modules.live.entity.ALiveResvGifts;
import com.thinkgem.jeesite.modules.live.service.ALiveResvGiftsService;

/**
 * 礼物收益Controller
 * @author 谢辉
 * @version 2018-01-28
 */
@Controller
@RequestMapping(value = "${adminPath}/live/aLiveResvGifts")
public class ALiveResvGiftsController extends BaseController {

	@Autowired
	private ALiveResvGiftsService aLiveResvGiftsService;
	
	@ModelAttribute
	public ALiveResvGifts get(@RequestParam(required=false) String id) {
		ALiveResvGifts entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = aLiveResvGiftsService.get(id);
		}
		if (entity == null){
			entity = new ALiveResvGifts();
		}
		return entity;
	}
	
	@RequiresPermissions("live:aLiveResvGifts:view")
	@RequestMapping(value = {"list", ""})
	public String list(ALiveResvGifts aLiveResvGifts, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ALiveResvGifts> page = aLiveResvGiftsService.findPage(new Page<ALiveResvGifts>(request, response), aLiveResvGifts); 
		model.addAttribute("page", page);
		model.addAttribute("aLiveResvGifts", aLiveResvGifts);
		return "modules/live/aLiveResvGiftsList";
	}

	@RequiresPermissions("live:aLiveResvGifts:view")
	@RequestMapping(value = "form")
	public String form(ALiveResvGifts aLiveResvGifts, Model model) {
		model.addAttribute("aLiveResvGifts", aLiveResvGifts);
		return "modules/live/aLiveResvGiftsForm";
	}

	@RequiresPermissions("live:aLiveResvGifts:edit")
	@RequestMapping(value = "save")
	public String save(ALiveResvGifts aLiveResvGifts, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, aLiveResvGifts)){
			return form(aLiveResvGifts, model);
		}
		aLiveResvGiftsService.save(aLiveResvGifts);
		addMessage(redirectAttributes, "保存礼物收益成功");
		return "redirect:"+Global.getAdminPath()+"/live/aLiveResvGifts/?repage";
	}
	
	@RequiresPermissions("live:aLiveResvGifts:edit")
	@RequestMapping(value = "delete")
	public String delete(ALiveResvGifts aLiveResvGifts, RedirectAttributes redirectAttributes) {
		aLiveResvGiftsService.delete(aLiveResvGifts);
		addMessage(redirectAttributes, "删除礼物收益成功");
		return "redirect:"+Global.getAdminPath()+"/live/aLiveResvGifts/?repage";
	}

}