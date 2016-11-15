package com.sxs.external.dao.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sxs.external.dao.datasource.TargetDataSource;
import com.sxs.external.dao.model.ManagerUserInfo;

@Component
public class ManagerUserInfoMapper {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@TargetDataSource(name="manager")
	public List<ManagerUserInfo> getList(){
		String sql = "select * from m_user_info";
		return (List<ManagerUserInfo>)jdbcTemplate.query(sql, new BeanPropertyRowMapper(ManagerUserInfo.class));
	}
}
