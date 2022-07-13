//package com.spring.dto;
//
//
//
//import com.spring.Entity.Board;
//import com.spring.Entity.FileEntity;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@Builder
//@AllArgsConstructor
//public class FileDTO {
//	
//	private Long id;
//	
//	private String originalFileName;
//	
//	private String fileName;
//	
//	private String filePath;
//	
//	private Board board;
//	
//	public FileEntity toEntity(FileDTO fileDTO) {
//		FileEntity fileEntity = FileEntity.builder()
//										.fileName(fileDTO.getFileName())
//										.originalFileName(fileDTO.getOriginalFileName())
//										.filePath(fileDTO.getFilePath())
//										.board(fileDTO.getBoard())
//										.build();
//		return fileEntity;
//		
//	}
//}
