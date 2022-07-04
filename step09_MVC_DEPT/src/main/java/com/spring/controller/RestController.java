package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.service.DeptServiceImpl;

import model.domain.Dept;

@org.springframework.web.bind.annotation.RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "http://localhost:3000")
public class RestController {
	
	@Autowired
	private DeptServiceImpl deptService;
	
	@GetMapping(value = "/api/dept/{deptno}")
	public Dept selectDept(@PathVariable int deptno) {
		System.out.println(deptno);
		Dept dept =deptService.getDeptByDeptno(deptno);
		System.out.println(dept);
		return deptService.getDeptByDeptno(deptno);
	}
	
	
	@PostMapping(value = "/api/dept",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void insertDept(Dept dept) {
		deptService.insertDept(dept);
	}
	
	@DeleteMapping(value = "/api/dept/{deptno}")
	public void deleteDept(@PathVariable int deptno) {
		
		deptService.deleteDeptBydeptno(deptno);
	}
	
	@PutMapping(value = "api/dept",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateDept(@RequestBody Dept dept) {
		System.out.println(dept);
		deptService.updateDeptBydeptno(dept);
	}
	
	
	
}
	
