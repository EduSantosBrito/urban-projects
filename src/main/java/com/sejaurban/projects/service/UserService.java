package com.sejaurban.projects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sejaurban.projects.converter.UserConverter;
import com.sejaurban.projects.dto.UserDTO;
import com.sejaurban.projects.exception.UnauthorizedException;
import com.sejaurban.projects.exception.UserNotFoundException;
import com.sejaurban.projects.exception.WrongCredentialsException;
import com.sejaurban.projects.model.User;
import com.sejaurban.projects.repository.UserRepository;
import com.sejaurban.projects.security.TokenAuthenticationService;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void save(UserDTO userDTO) {
		userRepository.save(UserConverter.getUserAsModel(userDTO));
	}

	public List<UserDTO> findAll() {
		return UserConverter.getListAsDTO(userRepository.findAll());
	}

	public UserDTO findById(Long id) {
		return UserConverter.getUserAsDTO(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException()));
	}

	public void edit(Long id, UserDTO userDTO) {
		userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
		userRepository.save(UserConverter.getUserAsModel(userDTO));
	}

	public void delete(Long id) {
		userRepository.delete(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException()));
	}

	public ResponseEntity<Object> findByEmailAndPassword(UserDTO userDTO) {
		User account = userRepository.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword())
				.orElseThrow(() -> new WrongCredentialsException());
		return createToken(account);
	}

	private ResponseEntity<Object> createToken(User account) {
		return new ResponseEntity<>(
				TokenAuthenticationService.addAuthentication(account.getPermissionType().toString()), HttpStatus.OK);
	}
}
