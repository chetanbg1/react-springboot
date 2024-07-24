package com.gfarm.fullStack_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gfarm.fullStack_backend.model.User;

public interface UserRepository extends JpaRepository<User, Long>{


	

}
