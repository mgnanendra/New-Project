/**
 * 
 */
package com.user.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author muduns
 * 
 */
@XmlRootElement
public class UserDTOs {

	public List<UserDTO> user = new ArrayList<UserDTO>();

	public UserDTOs() {
	}

	public UserDTOs(List<UserDTO> users) {
		super();
		this.user = users;
	}

}
