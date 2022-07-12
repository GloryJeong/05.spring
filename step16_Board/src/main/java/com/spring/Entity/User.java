package com.spring.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
public class User {
	
	@Id
	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@CreatedDate
	@Column(name = "registered_date")
	private LocalDateTime registerdDate;
	
	@CreatedDate
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Board> board = new ArrayList<Board>();
	
	public UserDTO toDTO(User user) {
		UserDTO userDTO	= UserDTO.builder()
							.userEmail(user.getUserEmail())
							.userName(user.getUserName())
							.userPassword(user.getUserPassword())
							.registerdDate(user.getRegisterdDate())
							.modifiedDate(user.getModifiedDate())
							.build();
		return userDTO;
	}
	
}
