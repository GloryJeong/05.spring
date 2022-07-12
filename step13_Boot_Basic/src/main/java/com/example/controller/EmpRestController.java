package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EmpDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.model.Emp;
import com.example.service.EmpServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmpRestController {
	
	@Autowired
	EmpServiceImpl empService;
	
	@GetMapping(value = "/emps")
	public PageResultDTO<EmpDTO,Emp> getEmps(PageRequestDTO pageDTO){
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
										.page(pageDTO.getPage())
										.size(5)
										.build();
		PageResultDTO<EmpDTO, Emp> pageResultDTO = empService.getList(pageRequestDTO);
		return pageResultDTO;
	}
	
	@GetMapping(value = "/emp/{empno}")
	public EmpDTO getEmpByEmpno(@PathVariable Long empno) {
		return empService.getEmpByEmpno(empno);
	}
	@PostMapping(value = "/emp",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveEmp(@RequestBody EmpDTO empDTO) {
		empService.saveEmp(empDTO);
	}
	
	@DeleteMapping(value = "/emp/{empno}")
	public void deleteByEmpno(@PathVariable Long empno) {
		empService.deleteByEmpno(empno);
	}
	
	@Transactional
	@PutMapping(value = "/emp/{empno}" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateByEmpno(@RequestBody EmpDTO empDTO,@PathVariable Long empno) {
		empDTO.setEmpno(empno);
		empService.updateByEmpno(empDTO);
	}
	
}
