package com.example.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.dto.EmpDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Emp {
	
	@Id
	private Long empno;
	
	@Column(length = 10)
	private String ename;
	
	@Column(length = 9)
	private String job;
	
	private Integer mgr;
	
	private Date hiredate;
	
	private Double sal;
	
	private Double comm;
	
	@ManyToOne
	@JoinColumn(name = "deptno")
	private Dept dept;
	
//	public Emp(Emp newEmp,Emp oldEmp) {
//		empno = oldEmp.getEmpno();
//		if(newEmp.getEname() != null) {
//			ename = newEmp.getEname();
//		}else {
//			ename = oldEmp.getEname();
//		}
//		if(newEmp.getJob() != null) {
//			job = newEmp.getJob();
//		}else {
//			job = oldEmp.getJob();
//		}
//		if(newEmp.getMgr() != null) {
//			mgr = newEmp.getMgr();
//		}else {
//			mgr = newEmp.getMgr();
//		}
//		if(newEmp.getHiredate() != null) {
//			hiredate = newEmp.getHiredate();
//		}else {
//			hiredate = oldEmp.getHiredate();
//		}
//		if(newEmp.getSal() != null) {
//			sal = newEmp.getSal();
//		}else {
//			sal = oldEmp.getSal();
//		}
//		if(newEmp.getComm() != null) {
//			comm = newEmp.getComm();
//		}else {
//			comm = oldEmp.getComm();
//		}
//		if(newEmp.getDept() != null) {
//			dept = newEmp.getDept();
//		}else {
//			dept = oldEmp.getDept();
//		}
//	}
	public EmpDTO toDTO(Emp empEntity) {
		Dept dept = empEntity.getDept();
		
		EmpDTO empDTO = EmpDTO.builder()
						.empno(empEntity.getEmpno())
						.ename(empEntity.getEname())
						.job(empEntity.getJob())
						.mgr(empEntity.getMgr())
						.hiredate(empEntity.getHiredate())
						.sal(empEntity.getSal())
						.comm(empEntity.getComm())
						.dept(dept ==null?null:dept.toDTO(dept))
						.build();
		return empDTO;
	}
	
}