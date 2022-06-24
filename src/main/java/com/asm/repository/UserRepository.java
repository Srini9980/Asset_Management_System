package com.asm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asm.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findByUserRole(String role);
	
	@Query("select u from User u where u.userName = :uname and u.password = :upassword and u.userRole = :role")
	User login(@Param("uname")String userName, @Param("upassword")String password, @Param("role") String userRole);
	
}
