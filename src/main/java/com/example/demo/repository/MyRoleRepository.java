package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MyRole;

@Repository
public interface MyRoleRepository extends JpaRepository<MyRoleRepository, Integer> {

	@Query("SELECT u FROM MyRole u WHERE u.role= ?1")
	Optional<MyRole> findByRole(String role);
}
