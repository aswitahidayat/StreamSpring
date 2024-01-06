package com.example.streamspring.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDetailsDTO {
	private String username;
	private String street;
	private String city;
	private String roleName;

}
