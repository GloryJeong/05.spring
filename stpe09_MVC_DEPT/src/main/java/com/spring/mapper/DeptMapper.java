package com.spring.mapper;

import model.domain.Dept;

public interface DeptMapper {
	
	// select
	public Dept getDeptByDeptno(int deptno);
	
	// delete
	public void deleteDeptBydeptno(int deptno);
	
	// insert
	public void insertDept(Dept dept);
	
	// Update
	public void updateDeptBydeptno(Dept dept);

}
