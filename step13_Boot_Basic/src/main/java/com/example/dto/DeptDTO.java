package com.example.dto;




import com.example.model.Dept;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptDTO {

	private Long deptno;
	
	private String dname;
	
	private String loc;
	
	
	public Dept dtoToEntity(DeptDTO deptDTO){
		Dept deptEntity = Dept.builder()
				.deptno(deptDTO.getDeptno())
				.dname(deptDTO.getDname())
				.loc(deptDTO.getLoc())
				.build();				
		return deptEntity;
	}

	public DeptDTO(DeptDTO newDept,DeptDTO oldDept) {
		
		deptno=newDept.getDeptno();
		if(newDept.getDname() != null) {
			dname = newDept.getDname();
		}else {
			dname = oldDept.getDname();
		}
		if(newDept.getLoc() != null) {
			loc = newDept.getLoc();
		}else {
			loc = oldDept.getLoc();
		}
	}
}
