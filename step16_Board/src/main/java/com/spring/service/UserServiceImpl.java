package com.spring.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.Entity.Comment;
import com.spring.Entity.User;
import com.spring.dto.CommentDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.dto.UserDTO;
import com.spring.repository.CommentRepository;
import com.spring.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	@Override
	public void insertUser(UserDTO userDTO) {
		if(userDTO != null) {
		User userEntity = userDTO.toEntity(userDTO);
		userRepository.save(userEntity);
		}
	}
	
	public PageResultDTO<UserDTO, User> getList(PageRequestDTO pageRequestDTO) {
	      Pageable pageable = pageRequestDTO.getPageable(Sort.by("userEmail").ascending());
	      
	      Page<User> result =  userRepository.findAll(pageable);
	      
	      // entity -> dto
	      Function<User, UserDTO> function = (userEntity -> userEntity.toDTO(userEntity));
	      
	      return new PageResultDTO<UserDTO, User>(result, function);
	   }
	
	@Override
	public UserDTO getUserByUserEmail(String userEmail) {
		User user=userRepository.getUserByUserEmail(userEmail);
		return user.toDTO(user);
	}
	
	
}
