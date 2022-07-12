package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;


import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.FileDTO;
import com.spring.entity.FileEntity;
import com.spring.repository.FileRepository;
import com.spring.service.FileServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FileController {
	
	final FileServiceImpl fileServiceImpl;
	final FileRepository fileRepository;
	
	@PostMapping("/file-save-test")
	public void saveFileTest(@RequestParam("file") MultipartFile multiFile) {
		try {
			System.out.println(multiFile);
			System.out.println(multiFile.getContentType());
			System.out.println(multiFile.getName());
		
			// 파일 저장시 이름 구분
			String originalFileName = multiFile.getOriginalFilename();
			System.out.println(originalFileName);
			String fileName =UUID.randomUUID().toString()+"_"+originalFileName;
			System.out.println(fileName);
			
			//파일 저장시 경로 설정
			String filePath = System.getProperty("user.dir") + "\\files";
			System.out.println(filePath);
			
			// 저장폴더가 존재 하지 않을 경우 -> 반드시 생성을 해줘야 함
			if(!new File(filePath).exists()) {
				new File(filePath).mkdir();
			}
			String finalFilePath = filePath + "\\" + fileName;
				multiFile.transferTo(new File(finalFilePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@CrossOrigin(value = "http://localhost:3000")
	@GetMapping("/file-list") 
	public List<FileDTO> showFileList() {
		return fileServiceImpl.findAll();
	}
	@PostMapping("/file-save")
	public ResponseEntity<Long> saveFile(@RequestParam("file") MultipartFile multiFile) {
		try {
			System.out.println(multiFile);
			System.out.println(multiFile.getContentType());
			System.out.println(multiFile.getName());
		
			// 파일 저장시 이름 구분
			String originalFileName = multiFile.getOriginalFilename();
			System.out.println(originalFileName);
			String fileName =UUID.randomUUID().toString()+"_"+originalFileName;
			System.out.println(fileName);
			
			//파일 저장시 경로 설정
			String filePath = System.getProperty("user.dir") + "\\files";
			System.out.println(filePath);
			
			// 저장폴더가 존재 하지 않을 경우 -> 반드시 생성을 해줘야 함
			if(!new File(filePath).exists()) {
				new File(filePath).mkdir();
			}
			String finalFilePath = filePath + "\\" + fileName;
				multiFile.transferTo(new File(finalFilePath));
			
			FileDTO fileDTO = FileDTO.builder()
								.originalFileName(originalFileName)
								.fileName(fileName)
								.filePath(finalFilePath)
								.build();
			Long fileID = fileServiceImpl.saveFile(fileDTO);
			return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:3000")).body(fileID);
			
			/*
	          * 게시판 글 생성이라 가정한다면?
	          * boardDTO.setFileDTO(fileDTO);
	          * boardDTO.setFileId(fileId);
	          * boardServiceImpl.saveBoard(boardDTO);
	          */
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	@GetMapping("/file-download/{id}")
//	public void downloadFile(@PathVariable Long id, HttpServletResponse response) throws FileNotFoundException{
//		FileDTO file = fileServiceImpl.findById(id);
//		response.setHeader("Content-Disposition", "attachment;filename=\""+file.getFileName()+"\";");
//		FileInputStream fis = new FileInputStream(file.getFilePath());
//		try {
//			OutputStream os = response.getOutputStream();
//			int readCount = 0;
//			byte[] buffer = new byte[1024];
//			while((readCount = fis.read(buffer)) != -1) {
//				os.write(buffer, 0, readCount);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	// https://developer.mozilla.org/ko/docs/Web/HTTP/Headers/Content-Disposition
	
	@GetMapping("/file-download/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable Long id) throws IOException {
	  FileEntity fileEntity = fileRepository.findById(id).get();

	  Path path = Paths.get(fileEntity.getFilePath());
	  Resource resource = new InputStreamResource(Files.newInputStream((path)));

	  HttpHeaders headers = new HttpHeaders();
	  headers.setContentDisposition(ContentDisposition.builder("attachment")
	                  .filename(fileEntity.getOriginalFileName(), StandardCharsets.UTF_8)
	                  .build());
	  headers.add(HttpHeaders.CONTENT_TYPE, "text/plain");

	  return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
}
