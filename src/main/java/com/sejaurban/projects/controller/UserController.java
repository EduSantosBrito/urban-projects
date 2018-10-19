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

import com.sejaurban.projects.dto.UserDTO;
import com.sejaurban.projects.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("add")
	public void add(@RequestBody UserDTO userDTO) {
		userService.save(userDTO);
	}
	
	@GetMapping("get/all")
	public List<UserDTO> findAll() {
		return userService.findAll();
	}
	
	@GetMapping("get/{id}")
	public UserDTO findById(@PathVariable("id") Long id) {
		return userService.findById(id);
	}
	
	@PutMapping("edit/{id}")
	public void edit(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
		userService.edit(id, userDTO);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		userService.delete(id);
	}
}
