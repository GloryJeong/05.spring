package com.spring.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.dto.CommentDTO;

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
public class Comment {
	
	@Id
	@Column(name = "comment_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentNo;
	
	@ManyToOne
	@JoinColumn(name = "board_no")
	private Board board;
	
	private String commenter;
	
	@Column(name = "comment_content")
	private String commentContent;
	
	@CreatedDate
	@Column(name = "registerd_date")
	private LocalDateTime registerdDate;
	
	@LastModifiedDate
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;
	
	public CommentDTO toDTO(Comment comment) {
		CommentDTO commentDTO = CommentDTO.builder()
								.commentNo(comment.getCommentNo())
								.board(comment.getBoard())
								.commenter(comment.getCommenter())
								.commentContent(comment.getCommentContent())
								.registerdDate(comment.getRegisterdDate())
								.modifiedDate(comment.getModifiedDate())
								.build();
		return commentDTO;
	}

}
