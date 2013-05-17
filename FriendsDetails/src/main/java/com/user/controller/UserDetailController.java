/**
 * 
 */
package com.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author muduns
 * 
 */
@Controller
@RequestMapping("/home")
public class UserDetailController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView welCome() {

		ModelAndView model = new ModelAndView("welcomepage");
		return model;
	}

}
