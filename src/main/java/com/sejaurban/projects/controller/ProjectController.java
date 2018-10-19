package com.sejaurban.projects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sejaurban.projects.dto.ProjectDTO;
import com.sejaurban.projects.service.ProjectService;

@RestController
@RequestMapping("project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@PostMapping("add")
	public void add(@RequestBody ProjectDTO projectDTO) {
		projectService.save(projectDTO);
	}
	
	@GetMapping("get/all")
	public List<ProjectDTO> findAll() {
		return projectService.findAll();
	}
	
	@GetMapping("get/{id}")
	public ProjectDTO findById(@PathVariable("id") Long id) {
		return projectService.findById(id);
	}
	
	@PutMapping("edit/{id}")
	public void edit(@PathVariable("id") Long id, @RequestBody ProjectDTO projectDTO) {
		projectService.edit(id, projectDTO);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		projectService.delete(id);
	}
}
