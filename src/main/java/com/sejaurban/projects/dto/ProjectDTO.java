package com.sejaurban.projects.dto;

import java.util.List;

public class ProjectDTO {
	
	private Long id;
	private String title;
	private String description;
	private StatusStateDTO status;
	private List<UserDTO> users;

	public ProjectDTO() {
	}

	public ProjectDTO(Long id, String title, String description, StatusStateDTO status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StatusStateDTO getStatus() {
		return status;
	}

	public void setStatus(StatusStateDTO status) {
		this.status = status;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
	
	

}
