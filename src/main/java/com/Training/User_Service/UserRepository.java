package com.Training.User_Service;

import com.Training.User_Service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
