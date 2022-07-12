package com.spring.dto;

import java.time.LocalDateTime;

import com.spring.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private String userEmail;
	
	private String userName;
	
	private String userPassword;
	
	private LocalDateTime registerdDate;
	
	private LocalDateTime modifiedDate;
	
	public User toEntity(UserDTO userDTO) {
		User userEntity = User.builder()
						.userEmail(userDTO.getUserEmail())
						.userName(userDTO.getUserName())
						.userPassword(userDTO.getUserPassword())
						.registerdDate(userDTO.getRegisterdDate())
						.modifiedDate(userDTO.getModifiedDate())
						.build();
		return userEntity;
	}
}
