package com.spring.dto;

import java.time.LocalDateTime;



import com.spring.Entity.Board;
import com.spring.Entity.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
	
	private Long commentNo;
	
	private Board board;
	
	private String commenter;
	
	private String commentContent;
	
	private LocalDateTime registerdDate;
	
	private LocalDateTime modifiedDate;
	
	public Comment toEntity(CommentDTO commentDTO) {
		Comment commentEntitiy = Comment.builder()
									.commentNo(commentDTO.getCommentNo())
									.board(commentDTO.getBoard())
									.commenter(commentDTO.getCommenter())
									.commentContent(commentDTO.getCommentContent())
									.registerdDate(commentDTO.getRegisterdDate())
									.modifiedDate(commentDTO.getModifiedDate())
									.build();
		return commentEntitiy;
	}
	
	public CommentDTO(CommentDTO commentDTO,CommentDTO oldCommentDTO) {
		commentNo = oldCommentDTO.getCommentNo();
		registerdDate = oldCommentDTO.getRegisterdDate();
		board = oldCommentDTO.getBoard();
		commenter = oldCommentDTO.getCommenter();
		if(commentDTO.getCommentContent() != null) {
			commentContent = commentDTO.getCommentContent();
		}else {
			commentContent = oldCommentDTO.getCommentContent();
		}
	}
	
}
