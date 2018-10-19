package com.sejaurban.projects.dto;

import java.util.List;

public class UserDTO {
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private Integer permissionType;
	private List<ProjectDTO> projects;

	public UserDTO() {
	}
	
	public UserDTO(Long id, String name, String email, String password, Integer permissionType, List<ProjectDTO> projects) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.permissionType = permissionType;
		this.projects = projects;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(Integer permissionType) {
		this.permissionType = permissionType;
	}

	public List<ProjectDTO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}
	

}
