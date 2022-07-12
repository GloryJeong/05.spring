package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.dto.FileDTO;
import com.spring.entity.FileEntity;
import com.spring.repository.FileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
	private final FileRepository fileRepository;

	@Override
	public Long saveFile(FileDTO fileDTO) {
		FileEntity fileEntity = fileDTO.toEntity(fileDTO);
		return fileRepository.save(fileEntity).getId();
	}

	public List<FileDTO> findAll() {
		List<FileEntity> fileEntityList = fileRepository.findAll();
		List<FileDTO> fileDTOList = new ArrayList<FileDTO>();
		fileEntityList.forEach(v->fileDTOList.add(v.toDTO(v)));
		return fileDTOList;
	}

	public FileDTO findById(Long id) {
		FileEntity fileEntity =fileRepository.findById(id).get();
		return fileEntity.toDTO(fileEntity);
		
	}
}
