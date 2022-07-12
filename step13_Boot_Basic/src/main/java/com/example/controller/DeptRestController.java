package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.DeptDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.model.Dept;
import com.example.service.DeptServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DeptRestController {
	
	@Autowired
	DeptServiceImpl deptService;
	
	@GetMapping(value = "/depts")
	public PageResultDTO<DeptDTO, Dept> getDepts(PageRequestDTO pageDTO){
		System.out.println(pageDTO);
		
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.page(pageDTO.getPage())
				.size(5)
				.build();
		PageResultDTO<DeptDTO, Dept> pageResultDTO = deptService.getList(pageRequestDTO);
		System.out.println(pageResultDTO);
		return pageResultDTO;
	}
	
	@GetMapping(value = "/dept/{deptno}")
	public DeptDTO getDeptByDeptno(@PathVariable Long deptno) {
		System.out.println(deptno);
		DeptDTO dept =deptService.getDeptByDeptno(deptno);
		System.out.println(dept);
		return dept;
	}
	@PostMapping(value = "/dept",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void savetDept(DeptDTO deptDTO) {
		System.out.println(deptDTO);
		deptService.saveDept(deptDTO);
	}
	
	@DeleteMapping(value = "/dept/{deptno}")
	public void deleteByDeptno(@PathVariable Long deptno) {
		deptService.deleteByDeptno(deptno);
	}
	@PutMapping(value = "/dept/{deptno}" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateByDeptno(@RequestBody DeptDTO updateDeptDTO, @PathVariable Long deptno) {
		updateDeptDTO.setDeptno(deptno);
		deptService.updateByDeptno(updateDeptDTO);
	}
	
}
