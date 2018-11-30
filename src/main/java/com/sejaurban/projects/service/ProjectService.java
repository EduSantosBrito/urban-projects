package com.sejaurban.projects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sejaurban.projects.converter.ProjectConverter;
import com.sejaurban.projects.dto.ProjectDTO;
import com.sejaurban.projects.exception.ProjectNotFoundException;
import com.sejaurban.projects.exception.StatusNotFoundException;
import com.sejaurban.projects.model.Project;
import com.sejaurban.projects.repository.ProjectRepository;
import com.sejaurban.projects.repository.StatusStateRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private StatusStateRepository statusStateRepository;
	
	public void save(ProjectDTO projectDTO) {
		Project project = ProjectConverter.getProjectAsModel(projectDTO);
//		project.setStatus(statusStateRepository.findStatusContaining(project.getStatus().getStatusName()).orElseThrow(() -> new StatusNotFoundException()));
		projectRepository.save(project);
	}

	public List<ProjectDTO> findAll() {
		return ProjectConverter.getListAsDTO(projectRepository.findAll());
	}

	public ProjectDTO findById(Long id) {
		return ProjectConverter.getProjectAsDTO(projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException()));
	}

	public void edit(Long id, ProjectDTO projectDTO) {
		projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException());
		projectRepository.save(ProjectConverter.getProjectAsModel(projectDTO));
	}

	public void delete(Long id) {
		projectRepository.delete(projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException()));
	}
}
