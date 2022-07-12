package com.example.service;

import java.util.List;

import com.example.dto.DeptDTO;
import com.example.model.Dept;

public interface DeptService {
	
	public List<Dept> getDeptAll();

	public DeptDTO getDeptByDeptno(Long deptno);
	
	public void deleteByDeptno(Long deptno);

	public void updateByDeptno(DeptDTO deptDTO);

	public void saveDept(DeptDTO deptDTO);
}
