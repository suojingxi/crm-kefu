package com.sxs.external.dao.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sxs.external.dao.model.AssetsLiabilities;

@Component
public class AssetsLiabilitiesMapper {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertAssetsLiabilities(AssetsLiabilities assetsLiabilities) {
		String sql = "insert into assets_liabilities (stkcd, accper, typrep, indcd, f011201a) values (?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, new Object[] { assetsLiabilities.getStkcd(), assetsLiabilities.getAccper(),
				assetsLiabilities.getTyprep(), assetsLiabilities.getIndcd(), assetsLiabilities.getF011201a() });
	}
}
