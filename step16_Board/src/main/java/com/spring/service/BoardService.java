package com.spring.service;

import com.spring.dto.BoardDTO;

public interface BoardService {
	public void insertBoard(BoardDTO boardDTO);

	public BoardDTO searchBoard(Long boardNo);

	public void deleteBoard(Long boardNo);

	public void updateBoard(BoardDTO boardDTO);
	
}
