/**
 * 
 */
package com.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.dao.UserDAO;
import com.user.domain.UserDTO;

/**
 * @author muduns
 * 
 */
@Transactional
@Service
public class UserServiceImpl implements UserDetails {

	@Autowired
	UserDAO userDAO;

	/**
	 * @param userDAO
	 *            the userDAO to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.user.services.UserDetails#getAllUser()
	 */
	public List<UserDTO> getAllUser() {
		return userDAO.getAllUsers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.user.services.UserDetails#createUser(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public UserDTO createUser(UserDTO userDTO) {
		userDAO.createUser(userDTO);

		return userDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.user.services.UserDetails#get(java.lang.String)
	 */
	public UserDTO get(String userId) {
		return userDAO.findById(userId);
	}

}
