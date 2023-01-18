package com.bettercoder.springbootwithreact.repositories;

import com.bettercoder.springbootwithreact.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
