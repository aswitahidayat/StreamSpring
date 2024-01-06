package com.example.streamspring.service;

import com.example.streamspring.dto.UserDetailsDTO;
import com.example.streamspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<UserDetailsDTO> fetchAndProcessUserDetails() {
		List<UserDetailsDTO> userDetailsList = userRepository.fetchUserDetailsWithAddressAndRole();

		return userDetailsList.stream()
				.filter(userDetails -> "New York".equals(userDetails.getCity()))
				.collect(Collectors.toList());
	}
}
