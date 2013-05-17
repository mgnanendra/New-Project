package com.user.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class UserDetailControllerTest {
	@Test
	public void testIstituteController() {
		UserDetailController controller = new UserDetailController();
		ModelAndView andView = controller.welCome();
		assertThat(andView.getViewName(), equalTo("welcomepage"));
	}

}
