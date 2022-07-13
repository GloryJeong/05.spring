package com.spring.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.dto.BoardDTO;

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
@EntityListeners(AuditingEntityListener.class)
@ToString
public class Board {
	
	@Id
	@Column(name = "board_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardNo;
	
	@ManyToOne
	@JoinColumn(name = "user_email",nullable = false)
	private User user;
	
	@Column(name = "board_title")
	private String boardTitle;
	
	@Column(name = "board_content")
	private String boardContent;
	
	@CreatedDate
	@Column(name="registered_date")
	private LocalDateTime registeredDate;
	
	@LastModifiedDate
	@Column(name="modified_date")
	private LocalDateTime modifiedDate;
	
	@OneToMany(mappedBy = "board")
	@JsonIgnore
	private List<Comment> comment = new ArrayList<Comment>();
	
//	@OneToOne
//	private FileEntity file;
	
	public BoardDTO toDTO(Board board) {
		BoardDTO boardDTO = BoardDTO.builder()
							.boardNo(board.getBoardNo())
							.user(getUser())
							.boardTitle(board.getBoardTitle())
							.boardContent(board.getBoardContent())
							.registeredDate(board.getRegisteredDate())
							.modifiedDate(board.getModifiedDate())
							.comment(board.getComment())
							.build();
		return boardDTO;
	}
	
}
