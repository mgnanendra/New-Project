/**
 * 
 */
package com.user.services;

import java.util.List;

import com.user.domain.UserDTO;

/**
 * @author muduns
 * 
 */
public interface UserDetails {
	List<UserDTO> getAllUser();

	UserDTO createUser(UserDTO userDTO);

	UserDTO get(String todoId);

}
