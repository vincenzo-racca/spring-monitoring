package com.vincenzoracca.springmonitoring.client.repos;


import com.vincenzoracca.springmonitoring.client.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
