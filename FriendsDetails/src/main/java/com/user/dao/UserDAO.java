/**
 * 
 */
package com.user.dao;

import java.util.List;

import com.user.domain.UserDTO;

/**
 * @author muduns
 * 
 */
public interface UserDAO {

	List<UserDTO> getAllUsers();

	UserDTO createUser(UserDTO userDTO);

	UserDTO findById(String userId);

}
