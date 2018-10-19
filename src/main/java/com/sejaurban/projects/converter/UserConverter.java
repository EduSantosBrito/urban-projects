package com.sejaurban.projects.converter;

import java.util.ArrayList;
import java.util.List;

import com.sejaurban.projects.dto.UserDTO;
import com.sejaurban.projects.model.User;

public class UserConverter {

	
	public static UserDTO getUserAsDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		userDTO.setPermissionType(user.getPermissionType());
		userDTO.setProjects(user.getProjects() != null ? ProjectConverter.getListAsDTO(user.getProjects()) : null);
		return userDTO;
	}
	
	public static User getUserAsModel(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setPermissionType(userDTO.getPermissionType());
		user.setProjects(userDTO.getProjects() != null ? ProjectConverter.getListAsModel(userDTO.getProjects()) : null);
		return user;
	}
	
	public static List<User> getListAsModel(List<UserDTO> listOfUserDTO) {
		List<User> listOfUser = new ArrayList<>();
		listOfUserDTO.forEach(userDTO -> {
			listOfUser.add(getUserAsModel(userDTO));
		});
		return listOfUser;
	}
	
	public static List<UserDTO> getListAsDTO(List<User> listOfUser) {
		List<UserDTO> listOfUserDTO = new ArrayList<>();
		listOfUser.forEach(user -> {
			listOfUserDTO.add(getUserAsDTO(user));
		});
		return listOfUserDTO;
	}
}
