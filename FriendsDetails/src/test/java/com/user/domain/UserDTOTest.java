package com.user.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UserDTOTest {

	@Test
	public void testUserDTO() {
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail("email");
		userDTO.setName("abc");
		userDTO.setNumber("1");

		assertThat(userDTO.getName(), equalTo("abc"));
	}

}
