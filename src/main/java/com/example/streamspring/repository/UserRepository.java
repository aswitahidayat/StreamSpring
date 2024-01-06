package com.example.streamspring.repository;

import com.example.streamspring.dto.UserDetailsDTO;
import com.example.streamspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT new com.example.dto.UserDetailsDTO(u.username, a.street, a.city, r.roleName) " +
			"FROM User u " +
			"JOIN UserRole ur ON u.id = ur.user.id " +
			"JOIN Role r ON ur.role.id = r.id " +
			"LEFT JOIN Address a ON u.id = a.user.id")
	List<UserDetailsDTO> fetchUserDetailsWithAddressAndRole();
}
