package com.sxs.external.dao.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sxs.external.dao.model.UserInfo;

@Component
public class UserInfoMapper {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<UserInfo> selectUserInfoList() {
		String sql = "select * from c_user_info";
		return (List<UserInfo>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(UserInfo.class));
	}

	public void insertUserInfo(UserInfo userInfo) {
		String sql = "insert into c_user_info (name, password, age) values(?, ?, ?)";
		this.jdbcTemplate.update(sql, new Object[]{userInfo.getName(), userInfo.getPassword(), userInfo.getAge()});
	}

	public void updateUserInfo(UserInfo userInfo) {
		String sql = "update c_user_info set name=?, password=?, age=? where id=?";
		this.jdbcTemplate.update(sql, new Object[]{userInfo.getName(), userInfo.getPassword(), userInfo.getAge(), userInfo.getId()});
	}

	public void deleteUserInfoById(Integer id) {
		String sql = "delete from t_user_info where id=?";
		this.jdbcTemplate.update(sql, id);
	}

	public Map<String, Object> getUserInfoById(Integer id) {
		String sql = "select * from c_user_info where id=?";
		return jdbcTemplate.queryForMap(sql, new Object[] { id });
	}
}
