package com.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.dto.Dept;

public interface DeptService {
	
	// resultType
	// String
	public String getDeptNameByDeptno(int deptno);
	
	public Dept getDeptByDeptno(int deptno);
	
	//HashMap
	public HashMap<String, Object> getDeptMap(int deptno);
	
	//List
	public List<Dept> getAllDepts();
	
	//List<HashMap<String,Object>>
	List<HashMap<String,Object>> getAllDeptsMap();
	
	//parameter
	//��ü
	public void insertDept(Dept dept);
	
	public void insertDepts(List<Dept> deptList);
	
	public void updateDeptByDeptnoAndDname(Map data);
	
	public void deleteDeptByLoc(String loc);
	
}
