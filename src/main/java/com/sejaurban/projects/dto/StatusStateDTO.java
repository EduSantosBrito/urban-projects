package com.sejaurban.projects.dto;

import java.util.List;

public class StatusStateDTO {
	
	private Long id;
	private List<ProjectDTO> projects;
	private String statusName;

	public StatusStateDTO() {
	
	}

	public StatusStateDTO(Long id, List<ProjectDTO> projects, String statusName) {
		super();
		this.id = id;
		this.projects = projects;
		this.statusName = statusName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ProjectDTO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
