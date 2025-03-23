package com.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{

}
