package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

	public Board getBoardByBoardNo(Long boardNo);
	
}
