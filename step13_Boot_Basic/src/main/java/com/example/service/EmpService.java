package com.example.service;

import java.util.List;

import com.example.dto.EmpDTO;
import com.example.model.Emp;


public interface EmpService {
	
	public List<EmpDTO> getEmpAll();

	public EmpDTO getEmpByEmpno(Long empno);
	
	public void deleteByEmpno(Long empno);

	public void updateByEmpno(EmpDTO empDTO);

	public void saveEmp(EmpDTO empDTO);


}
