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
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.live.entity.ALiveFollow;
import com.thinkgem.jeesite.modules.live.service.ALiveFollowService;

/**
 * 直播订阅Controller
 * 
 * @author 谢辉
 * @version 2018-01-28
 */
@Controller
@RequestMapping(value = "${adminPath}/live/aLiveFollow")
public class ALiveFollowController extends BaseController {

	@Autowired
	private ALiveFollowService aLiveFollowService;

	@ModelAttribute
	public ALiveFollow get(@RequestParam(required = false) String id) {
		ALiveFollow entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = aLiveFollowService.get(id);
		}
		if (entity == null) {
			entity = new ALiveFollow();
		}
		return entity;
	}

	@RequiresPermissions("live:aLiveFollow:view")
	@RequestMapping(value = { "list", "" })
	public String list(ALiveFollow aLiveFollow, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ALiveFollow> page = aLiveFollowService.findPage(new Page<ALiveFollow>(request, response), aLiveFollow);
		model.addAttribute("page", page);
		model.addAttribute("aLiveFollow", aLiveFollow);
		return "modules/live/aLiveFollowList";
	}

	@RequiresPermissions("live:aLiveFollow:view")
	@RequestMapping(value = "form")
	public String form(ALiveFollow aLiveFollow, Model model) {
		model.addAttribute("aLiveFollow", aLiveFollow);
		return "modules/live/aLiveFollowForm";
	}

	@RequiresPermissions("live:aLiveFollow:edit")
	@RequestMapping(value = "save")
	public String save(ALiveFollow aLiveFollow, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, aLiveFollow)) {
			return form(aLiveFollow, model);
		}
		aLiveFollowService.save(aLiveFollow);
		addMessage(redirectAttributes, "保存直播订阅成功");
		return "redirect:" + Global.getAdminPath() + "/live/aLiveFollow/?repage";
	}

	@RequiresPermissions("live:aLiveFollow:edit")
	@RequestMapping(value = "delete")
	public String delete(ALiveFollow aLiveFollow, RedirectAttributes redirectAttributes) {
		aLiveFollowService.delete(aLiveFollow);
		addMessage(redirectAttributes, "删除直播订阅成功");
		return "redirect:" + Global.getAdminPath() + "/live/aLiveFollow/?repage";
	}

}