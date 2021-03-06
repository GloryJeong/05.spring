package com.spring.dto;

import java.time.LocalDateTime;

import javax.persistence.Id;

import com.spring.entity.Diary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiaryDTO {
	
	@Id
	private Long no; 
	
	private String title;
	
	private String content;
	
	private LocalDateTime writtenTime;
	
	public Diary toEntity(DiaryDTO diaryDTO) {
		Diary diary = Diary.builder()
				.no(diaryDTO.getNo())
				.title(diaryDTO.getTitle())
				.content(diaryDTO.getContent())
				.build();
		return diary;
	}
}
