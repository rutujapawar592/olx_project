package com.zensar.olx.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olx.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
