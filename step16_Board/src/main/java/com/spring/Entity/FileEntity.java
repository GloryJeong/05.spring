//package com.spring.Entity;
//
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import com.spring.dto.FileDTO;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Builder
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "file")
//public class FileEntity {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	private String originalFileName;
//	
//	private String fileName;
//	
//	private String filePath;
//	
//	@JoinColumn(name = "board_no")
//	@OneToOne
//	private Board board;
//	
//	public FileDTO toDTO(FileEntity fileEntity) {
//		FileDTO fileDTO = FileDTO.builder()
//								.id(fileEntity.getId())
//								.originalFileName(fileEntity.getOriginalFileName())
//								.fileName(fileEntity.getFileName())
//								.filePath(fileEntity.getFilePath())
//								.board(fileEntity.getBoard())
//								.build();
//		return fileDTO;
//		
//	}
//	
////	@LastModifiedDate
////	private LocalDateTime modifiedDate;
//	
//	
//}
