package com.spring.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.spring.Entity.Board;
import com.spring.Entity.Comment;
import com.spring.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	
	private Long boardNo;
	
	private User user;
	
	private String boardTitle;
	
	private String boardContent;
	
	private LocalDateTime registeredDate;
	
	private LocalDateTime modifiedDate;
	
	private List<Comment> comment = new ArrayList<Comment>();
	
	public Board toEntity(BoardDTO boardDTO) {
		Board boardEntity = Board.builder()
							.boardNo(boardDTO.getBoardNo())
							.user(boardDTO.getUser())
							.boardTitle(boardDTO.getBoardTitle())
							.boardContent(boardDTO.getBoardContent())
							.registeredDate(getRegisteredDate())
							.modifiedDate(getModifiedDate())
							.build();
		return boardEntity;
	}

	public BoardDTO(BoardDTO boardDTO, BoardDTO oldBoardDTO) {
		boardNo = oldBoardDTO.getBoardNo();
		registeredDate = oldBoardDTO.getRegisteredDate();
		if(boardDTO.getUser() != null) {
			user=boardDTO.getUser();
		}else {
			user=oldBoardDTO.getUser();
		}
		if(boardDTO.getBoardContent() != null) {
			boardContent = boardDTO.getBoardContent();
		}else {
			boardContent = oldBoardDTO.getBoardContent();
		}
		if(boardDTO.getBoardTitle() != null) {
			boardTitle = boardDTO.getBoardTitle();
		}else {
			boardTitle = oldBoardDTO.getBoardTitle();
		}
	}
}
