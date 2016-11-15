package com.sxs.external.dao.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value=Include.NON_NULL)
public class ApiResponse {

	public static final String STATUS_OK = "OK";
	public static final String STATUS_FAIL = "FAIL";
	
	/**
	 * 标明请求是否成功
	 */
	private String status;
	private Integer count;
	private Integer totalCount;
	private List<?> data;
}
