package com.sxs.external.dao.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserInfo implements Serializable{
	
	private static final long serialVersionUID = 8001652861541338402L;

	private Integer id;
	private String name;
	private String password;
	private Integer age;
}
