package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Long> {

}
