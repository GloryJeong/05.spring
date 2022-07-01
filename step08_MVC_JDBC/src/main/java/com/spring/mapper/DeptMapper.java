package com.spring.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.dto.Dept;

public interface DeptMapper {
	
	// resultType
	// String
	public String getDeptNameByDeptno(int deptno);
	
	//°´Ã¼
	public Dept getDeptByDeptno(int deptno);
	
	//HashMap
	public HashMap<String, Object> getDeptMap(int deptno);
	
	//List
	public List<Dept> getAllDepts();
	
	//List<HashMap<String,Object>>
	List<HashMap<String,Object>> getAllDeptsMap();
	
	//parameter
	//°´Ã¼
	public void insertDept(Dept dept);
	
	public void insertDepts(List<Dept> deptList);
	
//	public void updateDeptByDeptnoAndDname(int deptno, String dname);
	public void updateDeptByDeptnoAndDname(Map data);
	
	public void deleteDeptByLoc(String loc);
	

}
