package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dto.EmpDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.model.Emp;
import com.example.repository.EmpRepository;


@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired 
	EmpRepository empRepository;
	
	
	@Override
	public List<EmpDTO> getEmpAll() {
		List<Emp> empList=empRepository.findAll();
		List<EmpDTO> empDTOList=new ArrayList<EmpDTO>();
		empList.forEach(v->empDTOList.add(v.toDTO(v)));
		return empDTOList;
	}
	
	@Override
	public EmpDTO getEmpByEmpno(Long empno) {
		Emp emp = empRepository.findEmpByEmpno(empno);
		if(emp != null) {
			return emp.toDTO(emp);			
		}else {
			return null;
		}
	}

	@Override
	public void deleteByEmpno(Long empno) {
		empRepository.deleteById(empno);
	}
	
	@Override
	public void updateByEmpno(EmpDTO empDTO) {
		EmpDTO oldEmpDTO = getEmpByEmpno(empDTO.getEmpno());
		if(oldEmpDTO != null) {
			EmpDTO newEmpDTO = new EmpDTO(empDTO,oldEmpDTO);
			empRepository.save(newEmpDTO.dtoToEntity(newEmpDTO));
		}
	}
	
	@Override
	public void saveEmp(EmpDTO empDTO) {
		EmpDTO oldEmpDTO = getEmpByEmpno(empDTO.getEmpno());
		if(oldEmpDTO == null) {
			empRepository.save(empDTO.dtoToEntity(empDTO));
		}
	}

	public PageResultDTO<EmpDTO, Emp> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("empno").ascending());
		Page<Emp> result = empRepository.findAll(pageable);
		
		Function<Emp,EmpDTO> function = (empEntity->empEntity.toDTO(empEntity));
		
		return new PageResultDTO<EmpDTO, Emp>(result, function);
	}

}
