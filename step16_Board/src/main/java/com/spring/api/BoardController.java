package com.spring.api;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Entity.Board;
import com.spring.dto.BoardDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.service.BoardServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardServiceImpl boardService;
	
	@GetMapping(value = "/boards")
	public PageResultDTO<BoardDTO, Board> getBoards(PageRequestDTO pageDTO){
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.page(pageDTO.getPage())
				.size(10)
				.build();
		PageResultDTO<BoardDTO, Board> pageResultDTO = boardService.getList(pageRequestDTO);
		return pageResultDTO;
	}
	
	@GetMapping(value = "/board/{boardNo}")
	public BoardDTO searchBoard(@PathVariable Long boardNo) {
		return boardService.searchBoard(boardNo); 
	}
	
	@PostMapping(value = "/board", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertBoard(@RequestBody BoardDTO boardDTO) {
		boardService.insertBoard(boardDTO);
	}
	
	@DeleteMapping(value = "/board/{boardNo}")
	public void deleteBoard(@PathVariable Long boardNo) {
		boardService.deleteBoard(boardNo);
	}
	
	@PutMapping(value = "/board/{boardNo}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateBoard(@RequestBody BoardDTO boardDTO,@PathVariable Long boardNo) {
		boardDTO.setBoardNo(boardNo);
		boardService.updateBoard(boardDTO);
	}


}
