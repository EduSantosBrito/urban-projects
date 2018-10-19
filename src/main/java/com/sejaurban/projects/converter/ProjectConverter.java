package com.sejaurban.projects.converter;

import java.util.ArrayList;
import java.util.List;

import com.sejaurban.projects.dto.ProjectDTO;
import com.sejaurban.projects.model.Project;

public class ProjectConverter {

	public static ProjectDTO getProjectAsDTO(Project project) {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setId(project.getId());
		projectDTO.setTitle(project.getTitle());
		projectDTO.setDescription(project.getDescription());
		projectDTO.setStatus(StatusStateConverter.getStatusStateAsDTO(project.getStatus()));
		projectDTO.setUsers(project.getUsers() != null ? UserConverter.getListAsDTO(project.getUsers()) : null);
		return projectDTO;
	}
	
	public static Project getProjectAsModel(ProjectDTO projectDTO) {
		Project project = new Project();
		project.setId(projectDTO.getId());
		project.setTitle(projectDTO.getTitle());
		project.setDescription(projectDTO.getDescription());
		project.setStatus(StatusStateConverter.getStatusStateAsModel(projectDTO.getStatus()));
		project.setUsers(projectDTO.getUsers() != null ? UserConverter.getListAsModel(projectDTO.getUsers()) : null);
		return project;
	}
	
	
	public static List<Project> getListAsModel(List<ProjectDTO> listOfProjectDTO) {
		List<Project> listOfProject = new ArrayList<>();
		listOfProjectDTO.forEach(projectDTO -> {
			listOfProject.add(getProjectAsModel(projectDTO));
		});
		return listOfProject;
	}
	
	public static List<ProjectDTO> getListAsDTO(List<Project> listOfProject) {
		List<ProjectDTO> listOfProjectDTO = new ArrayList<>();
		listOfProject.forEach(project -> {
			listOfProjectDTO.add(getProjectAsDTO(project));
		});
		return listOfProjectDTO;
	}
}
