/**
 * 
 */
package com.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.user.domain.UserDTO;

/**
 * @author muduns
 * 
 */
@Repository
public class UserDAOImpl implements UserDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSource")
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.user.dao.UserDAO#getAllUsers()
	 */
	public List<UserDTO> getAllUsers() {
		String query = "SELECT * FROM USERDETAILS";
		List<UserDTO> userDTOs = jdbcTemplate.query(query,
				new RowMapper<UserDTO>() {
					public UserDTO mapRow(ResultSet rs, int arg1)
							throws SQLException {
						UserDTO userDTO = new UserDTO();
						userDTO = new UserDTO();
						userDTO.setName(rs.getString("USERNAME"));
						userDTO.setNumber(rs.getString("NUMBER"));
						userDTO.setEmail(rs.getString("EMAIL"));
						return userDTO;
					}
				});
		// return (List<User>) list;
		return userDTOs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.user.dao.UserDAO#createUser(com.user.domain.UserDTO)
	 */
	public UserDTO createUser(UserDTO userDTO) {
		String sql = "INSERT INTO USERDETAILS VALUES(?,?,?)";
		jdbcTemplate.update(
				sql,
				new Object[] { userDTO.getName(), userDTO.getNumber(),
						userDTO.getEmail() });
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.user.dao.UserDAO#findById(java.lang.String)
	 */
	public UserDTO findById(String userId) {
		return jdbcTemplate.query(
				"SELECT * FROM USERDETAILS WHERE USERNAME = ?",
				new Object[] { userId }, new ResultSetExtractor<UserDTO>() {
					public UserDTO extractData(ResultSet rs)
							throws SQLException {
						UserDTO userDTO = null;
						if (rs.next()) {
							userDTO = new UserDTO();
							userDTO.setName(rs.getString("USERNAME"));
							userDTO.setNumber(rs.getString("NUMBER"));
							userDTO.setEmail(rs.getString("EMAIL"));

						}
						return userDTO;
					}
				});
	}

}
