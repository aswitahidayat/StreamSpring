package com.example.streamspring.entity;

import jakarta.persistence.*;

@Entity
public class UserRole {
	@Id
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
}
