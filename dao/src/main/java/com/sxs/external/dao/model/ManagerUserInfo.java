package com.sxs.external.dao.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ManagerUserInfo implements Serializable{

	private static final long serialVersionUID = -3486268735419349089L;
	
	private Integer id;
	private String name;
	private String password;
	private Integer age;
}
