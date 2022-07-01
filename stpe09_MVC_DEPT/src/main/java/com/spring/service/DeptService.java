package com.spring.service;

import java.util.Map;

import model.domain.Dept;

public interface DeptService {
	
	// select
	public Dept getDeptByDeptno(int deptno);
	
	// delete
	public void deleteDeptBydeptno(int deptno);
	
	// insert
	public void insertDept(Dept dept);
	
	// Update
	public void updateDeptBydeptno(Dept dept);
	
	
	
}
