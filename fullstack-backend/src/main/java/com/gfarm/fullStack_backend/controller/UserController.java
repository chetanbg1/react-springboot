package com.gfarm.fullStack_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.gfarm.fullStack_backend.exception.UserNotFoundException;
import com.gfarm.fullStack_backend.model.User;
import com.gfarm.fullStack_backend.repository.UserRepository;

@RestController
//@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	
	@PostMapping("/user")
	public User newUser(@RequestBody User newUser) {
		return userRepo.save(newUser);
	}
	
	@GetMapping("/users")
	public List<User> allUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id) {
		return userRepo.findById(id)
				.orElseThrow(()-> new UserNotFoundException(id));
	}
	
	@PutMapping("/user/{id}")
	public User editUser(@RequestBody User newUser,@PathVariable Long id) {
		return userRepo.findById(id)
				.map(user -> {
			user.setName(newUser.getName());
			user.setUserName(newUser.getUserName());
			user.setEmail(newUser.getEmail());
			return userRepo.save(user);
		}).orElseThrow(()-> new UserNotFoundException(id));
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable Long id) {
		if(!userRepo.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		 userRepo.deleteById(id);
		 return "user with id"+ id +"has been deleted";
	}

}
