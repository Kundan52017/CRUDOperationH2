package com.crud.operation.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.operation.dao.UserRepository;
import com.crud.operation.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		return userRepository.save(user);
		
	}
	public List<User> createUsers(List<User> users) {
		return userRepository.saveAll(users);
		
	}
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null); 
		
	}
	public List<User> getUsers() {
		return userRepository.findAll(); 
		
	}
	public User updateUser(User user) {
		User oldUser=null;
	Optional<User>optionaluser=userRepository.findById(user.getId());
	if(optionaluser.isPresent()) {
	    oldUser=optionaluser.get();
		oldUser.setName(user.getName());
		oldUser.setAddress(user.getAddress());
		userRepository.save(oldUser);
		
	}
	else {
		return new User();
	}
	return oldUser;
	}
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
		// "User get Delete Successfull";
		
	}
	
}


