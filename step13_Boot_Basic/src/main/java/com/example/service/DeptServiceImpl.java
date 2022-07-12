package com.example.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.model.Dept;
import com.example.repository.DeptRepository;
import com.example.dto.DeptDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	DeptRepository deptRepository;
	
	
	@Override
	public List<Dept> getDeptAll() {
		return deptRepository.findAll();
	}
	
	@Override
	public DeptDTO getDeptByDeptno(Long deptno) {
		Dept dept=deptRepository.findDeptByDeptno(deptno);
		if(dept != null) {
			DeptDTO deptDTO=dept.toDTO(dept);
			return deptDTO;
		}else {
			return null;
		}
	}

	@Override
	public void deleteByDeptno(Long deptno) {
		deptRepository.deleteById(deptno);
	}
	
	@Override
	public void updateByDeptno(DeptDTO deptDTO) {
		DeptDTO oldDeptDTO = getDeptByDeptno(deptDTO.getDeptno());
		if(oldDeptDTO != null) {
			DeptDTO newDept = new DeptDTO(deptDTO,oldDeptDTO);
			deptRepository.save(newDept.dtoToEntity(newDept));
		}
	}
	
	@Override
	public void saveDept(DeptDTO deptDTO) {
		DeptDTO oldDeptDTO = getDeptByDeptno(deptDTO.getDeptno());
		if(oldDeptDTO == null) {
			deptRepository.save(deptDTO.dtoToEntity(deptDTO));
		}
	}
	public PageResultDTO<DeptDTO, Dept> getList(PageRequestDTO pageRequestDTO) {
	      Pageable pageable = pageRequestDTO.getPageable(Sort.by("deptno").ascending());
	      
	      Page<Dept> result =  deptRepository.findAll(pageable);
	      
	      // entity -> 'dto
	      Function<Dept, DeptDTO> function = (deptEntity -> deptEntity.toDTO(deptEntity));
	      
	      return new PageResultDTO<DeptDTO, Dept>(result, function);
	   }

}
