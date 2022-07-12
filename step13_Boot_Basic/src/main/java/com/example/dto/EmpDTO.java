package com.example.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.model.Emp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpDTO {
	
	private Long empno;
	
	private String ename;
	
	private String job;
	
	private Integer mgr;
	
	private Date hiredate;
	
	private Double sal;
	
	private Double comm;
	
	@JoinColumn(name = "deptno")
	private DeptDTO dept;
	
	public EmpDTO(EmpDTO newEmp,EmpDTO oldEmp) {
		empno = oldEmp.getEmpno();
		if(newEmp.getEname() != null) {
			ename = newEmp.getEname();
		}else {
			ename = oldEmp.getEname();
		}
		if(newEmp.getJob() != null) {
			job = newEmp.getJob();
		}else {
			job = oldEmp.getJob();
		}
		if(newEmp.getMgr() != null) {
			mgr = newEmp.getMgr();
		}else {
			mgr = newEmp.getMgr();
		}
		if(newEmp.getHiredate() != null) {
			hiredate = newEmp.getHiredate();
		}else {
			hiredate = oldEmp.getHiredate();
		}
		if(newEmp.getSal() != null) {
			sal = newEmp.getSal();
		}else {
			sal = oldEmp.getSal();
		}
		if(newEmp.getComm() != null) {
			comm = newEmp.getComm();
		}else {
			comm = oldEmp.getComm();
		}
		if(newEmp.getDept() != null) {
			dept = newEmp.getDept();
		}else {
			dept = oldEmp.getDept();
		}
	}
	public Emp dtoToEntity(EmpDTO empDTO){
		DeptDTO deptDTO= empDTO.getDept();
		Emp empEntity = Emp.builder()
						.empno(empDTO.getEmpno())
						.ename(empDTO.getEname())
						.job(empDTO.getJob())
						.mgr(empDTO.getMgr())
						.hiredate(empDTO.getHiredate())
						.sal(empDTO.getSal())
						.comm(empDTO.getComm())
						.dept(deptDTO == null? null:deptDTO.dtoToEntity(deptDTO))
						.build();				
		return empEntity;
	}
	
	
}