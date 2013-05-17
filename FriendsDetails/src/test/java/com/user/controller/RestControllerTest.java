package com.user.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.user.domain.UserDTO;
import com.user.services.UserDetails;

public class RestControllerTest {
	UserDetails service;
	RestController controller;

	@Before
	public void setup() {
		service = Mockito.mock(UserDetails.class);
		controller = new RestController();
		controller.setUserDetails(service);
	}

	@Test(expected = NotFoundException.class)
	public void testDetails() {
		UserDTO dto = new UserDTO();
		dto.setName("abc");
		dto.setNumber("1");
		dto = controller.findById("abc");
		Mockito.verify(service).get("abc");
		assertThat(dto.getName(), equalTo("abc"));
	}
}
