/**
 * 
 */
package com.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

import com.user.domain.UserDTO;
import com.user.domain.UserDTOs;
import com.user.services.UserDetails;

/**
 * @author muduns
 * 
 */
@Controller
@RequestMapping("friends")
public class RestController {

	@Autowired
	private UserDetails userDetails;

	/**
	 * @param userDetails
	 *            the userDetails to set
	 */
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	// curl -X GET -i http://localhost:8080/UserDetails/friends/user
	@RequestMapping(value = "user", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
	UserDTOs studentDTOs() {
		return new UserDTOs(userDetails.getAllUser());
	}

	// curl -X GET -i http://localhost:8080/UserDetails/friends/user/{name}
	@RequestMapping(value = "user/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public UserDTO findById(@PathVariable String username) {
		UserDTO user = userDetails.get(username);
		if (user == null)
			throw new NotFoundException();
		return user;
	}

	// curl -X POST -i
	// http://localhost:8080/UserDetails/friends/user?text=studentItem
	@RequestMapping(value = "user", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestParam String number, @RequestParam String name,
			@RequestParam String email, HttpServletRequest req,
			HttpServletResponse resp) {
		UserDTO userDTO = new UserDTO();
		userDTO.setNumber(number);
		userDTO.setName(name);
		userDTO.setEmail(email);
		UserDTO stud = userDetails.createUser(userDTO);
		StringBuffer url = req.getRequestURL().append("/{id}");
		UriTemplate uriTemplate = new UriTemplate(url.toString());
		resp.addHeader("location", uriTemplate.expand(stud.getName())
				.toASCIIString());
	}

}

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
