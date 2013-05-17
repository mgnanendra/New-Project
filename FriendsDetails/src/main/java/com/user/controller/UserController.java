/**
 * 
 */
package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.domain.UserDTO;
import com.user.services.UserDetails;

/**
 * @author muduns
 * 
 */
@Controller
public class UserController {

	@Autowired
	UserDetails userDetails;

	@RequestMapping("/register")
	public String createUser(@RequestParam String number,
			@RequestParam String name, @RequestParam String email, Model model) {
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setNumber(number);
		userDTO.setEmail(email);
		userDetails.createUser(userDTO);
		model.addAttribute("userDetails", userDetails.getAllUser());
		return "userregsucess";
	}

	@RequestMapping("/details")
	public String userDetails(@RequestParam String name, Model model) {
		UserDTO userDTO = userDetails.get(name);
		model.addAttribute("userDetails", userDTO);
		return "userdetails";
	}

	@RequestMapping("/getall")
	public String allUsers(Model model) {
		model.addAttribute("userDetails", userDetails.getAllUser());
		return "allusers";
	}

	/**
	 * @param userDetails
	 *            the userDetails to set
	 */
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

}
