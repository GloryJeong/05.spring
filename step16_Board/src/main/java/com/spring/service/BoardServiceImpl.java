package com.spring.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.Entity.Board;
import com.spring.dto.BoardDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository boardRepository;
	
	@Override
	public void insertBoard(BoardDTO boardDTO) {
		BoardDTO oldBoardDTO = searchBoard(boardDTO.getBoardNo());
		if(oldBoardDTO == null) {
			Board boardEntity = boardDTO.toEntity(boardDTO);
			boardRepository.save(boardEntity);
		}
	}
	@Override
	public BoardDTO searchBoard(Long boardNo) {
		Board board=boardRepository.getBoardByBoardNo(boardNo);
		if(board != null) {
			return board.toDTO(board);
		}else {
			return null;
		}
	}
	
	public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO pageRequestDTO) {
	      Pageable pageable = pageRequestDTO.getPageable(Sort.by("boardNo").descending());
	      Page<Board> result =  boardRepository.findAll(pageable);
	      // entity -> dto
	      Function<Board, BoardDTO> function = (boardEntity -> boardEntity.toDTO(boardEntity));
	      
	      return new PageResultDTO<BoardDTO, Board>(result, function);
	   }
	
	@Override
	public void deleteBoard(Long boardNo) {
		BoardDTO boardDTO=searchBoard(boardNo);
		if(boardDTO !=null) {
			boardRepository.delete(boardDTO.toEntity(boardDTO));
		}
	}
	
	@Override
	public void updateBoard(BoardDTO boardDTO) {
		BoardDTO oldBoardDTO = searchBoard(boardDTO.getBoardNo());
		if(oldBoardDTO != null) {
			BoardDTO newBoardDTO = new BoardDTO(boardDTO,oldBoardDTO);
			boardRepository.save(newBoardDTO.toEntity(newBoardDTO));
		}
	}

	
	
	
}
