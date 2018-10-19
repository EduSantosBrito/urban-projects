package com.sejaurban.projects.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sejaurban.projects.state.StatusState;

@Repository
public interface StatusStateRepository extends JpaRepository<StatusState, Long>{
	
	@Query(value="SELECT * FROM status_state WHERE status_name = ?1", nativeQuery=true)
	Optional<StatusState> findStatusContaining(String status);
}
