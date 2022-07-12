package com.spring.service;

import java.util.List;

import com.spring.dto.CommentDTO;

public interface CommentService {
	public void insertComment(CommentDTO commentDTO);

	public List<CommentDTO> findAll();

	public List<CommentDTO> getCommentsByBoard(Long boardNo);

	public void deleteComment(Long commentNo);

	public void updateComment(CommentDTO commentDTO);

	


}
