package com.dreamfly.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/forward")
public class ForwardController {

	@RequestMapping(value = "/{page}")
	public String forward(@PathVariable String page) {
		return page;
	}

}
