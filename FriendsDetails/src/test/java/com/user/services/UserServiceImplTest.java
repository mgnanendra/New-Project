package com.user.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.user.dao.UserDAO;
import com.user.domain.UserDTO;

public class UserServiceImplTest {

	private UserServiceImpl userService;
	private UserDAO userDAO;

	@Before
	public void setup() {
		userDAO = Mockito.mock(UserDAO.class);
		userService = new UserServiceImpl();
		userService.setUserDAO(userDAO);
	}

	@Test
	public void testCreateStud() {
		UserDTO userDTO1 = new UserDTO();
		userDTO1.setName("abc");
		userDTO1.setEmail("email");
		userDTO1.setNumber("123");
		UserDTO userDTO = userService.createUser(userDTO1);
		Mockito.verify(userDAO).createUser(userDTO);
		assertThat(userDTO.getName(), equalTo("abc"));
	}

	@Test
	public void testFindById() {
		userService.get("1");
		Mockito.verify(userDAO).findById("1");

	}

}
