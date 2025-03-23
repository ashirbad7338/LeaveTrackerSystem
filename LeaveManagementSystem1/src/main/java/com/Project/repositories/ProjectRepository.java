package com.Project.repositories;

import com.Project.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // You can add custom queries if needed, but the default CRUD repository methods should suffice.
    List<Project> findAll();
  
}
