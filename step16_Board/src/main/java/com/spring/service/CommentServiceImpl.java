package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.Entity.Comment;
import com.spring.dto.CommentDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	
	private final CommentRepository commentRepository;
	
	@Override
	public void insertComment(CommentDTO commentDTO) {
		if(commentDTO != null) {
		Comment commentEntity = commentDTO.toEntity(commentDTO);
		commentRepository.save(commentEntity);
		}
	}
	
	public PageResultDTO<CommentDTO, Comment> getList(PageRequestDTO pageRequestDTO) {
	      Pageable pageable = pageRequestDTO.getPageable(Sort.by("commentNo").descending());
	      
	      Page<Comment> result =  commentRepository.findAll(pageable);
	      
	      // entity -> dto
	      Function<Comment, CommentDTO> function = (commentEntity -> commentEntity.toDTO(commentEntity));
	      
	      return new PageResultDTO<CommentDTO, Comment>(result, function);
	   }
	@Override
	public List<CommentDTO> findAll() {
		List<Comment> comment=commentRepository.findAll();
		List<CommentDTO> commentDTOList =new ArrayList<CommentDTO>();
		comment.forEach(v->commentDTOList.add(v.toDTO(v)));
		return commentDTOList;
	}

	@Override
	public List<CommentDTO> getCommentsByBoard(Long boardNo) {
//		Board board=boardRepository.getBoardByBoardNo(boardNo);
		List<Comment> comment =commentRepository.findByBoardBoardNo(boardNo);
		List<CommentDTO> commentDTOList = new ArrayList<CommentDTO>();
		comment.forEach(v->commentDTOList.add(v.toDTO(v)));
		return commentDTOList;
	}
	
	@Override
	public void updateComment(CommentDTO commentDTO) {
		Comment comment = commentRepository.getCommentByCommentNo(commentDTO.getCommentNo());
		if(comment != null) {
			CommentDTO oldCommentDTO = comment.toDTO(comment);
			CommentDTO newCommentDTO = new CommentDTO(commentDTO, oldCommentDTO);
			commentRepository.save(newCommentDTO.toEntity(newCommentDTO));
		}
	}

	@Override
	public void deleteComment(Long commentNo) {
		commentRepository.deleteById(commentNo);
	}
	
//	public void findGroupbyComment(int start,int end) {
//		System.out.println(commentRepository.findGroupbyComments(start,end));
//	}
	
	
	
}
