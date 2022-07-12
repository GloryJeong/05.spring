package com.spring.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.CommentDTO;
import com.spring.service.CommentServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class CommentController {
	
	private final CommentServiceImpl commentService;
	
//	@GetMapping(value = "/comments")
//	public List<CommentDTO> getComments(@RequestParam Long start,@RequestParam Long end){
//		System.out.println(start);
//		System.out.println(end);
//		return null;
//	}
	
	@GetMapping(value = "/comment/{boardNo}")
	public List<CommentDTO> boardComment(@PathVariable Long boardNo){
		List<CommentDTO> boardComments = commentService.getCommentsByBoard(boardNo);
		return boardComments;
	}
	
	@PostMapping(value="/comment", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertComment(@RequestBody CommentDTO commentDTO) {
		System.out.println(commentDTO);
		commentService.insertComment(commentDTO);
	}
	
	@DeleteMapping(value = "/comment/{commentNo}")
	public void deleteComment(@PathVariable Long commentNo) {
		commentService.deleteComment(commentNo);
	}
	
	@PutMapping(value = "/comment/{commentNo}")
	public void updateComment(@PathVariable Long commentNo,@RequestBody CommentDTO commentDTO) {
		System.out.println(commentDTO);
		commentDTO.setCommentNo(commentNo);
		commentService.updateComment(commentDTO);
	}
	
}
