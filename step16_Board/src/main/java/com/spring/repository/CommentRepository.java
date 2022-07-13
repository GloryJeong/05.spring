package com.spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.Entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {


	public Comment getCommentByCommentNo(Long commentNo);

	public List<Comment> findByBoardBoardNo(Long boardNo);
	
	@Query(value = "SELECT count(c.board_no) AS boardCount FROM Comment c "
			+ "GROUP BY c.board_no "
			+ "having c.board_no between :start and :end",nativeQuery = true)
	public List<Integer> findGroupbyComments(int start,int end);
	
	
}
