package com.gfarm.fullStack_backend.exception;

public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(Long id) {
		super("could not found the user with given id");
	}

}
