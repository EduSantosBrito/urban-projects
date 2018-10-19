package com.sejaurban.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sejaurban.projects.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
