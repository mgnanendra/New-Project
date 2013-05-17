package com.user.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UserDTOsTest {

	@Test
	public void testUserDTO() {
		UserDTO userDAO = new UserDTO();
		userDAO.setEmail("email");
		userDAO.setName("abc");
		userDAO.setNumber("1");
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		dtos.add(userDAO);
		UserDTOs useDTOs = new UserDTOs(dtos);

		assertThat(useDTOs.user.get(0).getName(), equalTo("abc"));
	}
}
