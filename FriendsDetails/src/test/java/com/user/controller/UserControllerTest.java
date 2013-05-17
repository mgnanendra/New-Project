package com.user.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import com.user.domain.UserDTO;
import com.user.services.UserDetails;

public class UserControllerTest {
	UserDetails service;
	UserController controller;

	@Before
	public void setup() {
		service = Mockito.mock(UserDetails.class);
		controller = new UserController();
		controller.setUserDetails(service);
	}

	@Test
	public void testDetails() {

		Model model = Mockito.mock(Model.class);

		String studentDTO = controller.userDetails("abc", model);
		Mockito.verify(model).addAttribute("userDetails", null);
		Mockito.verify(service).get("abc");
		assertThat(studentDTO, equalTo("userdetails"));
	}
}
