package com.spring.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.DeptMapper;

import model.domain.Dept;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	DeptMapper deptMapper;

	@Override
	public Dept getDeptByDeptno(int deptno) {
		return deptMapper.getDeptByDeptno(deptno);
	}

	@Override
	public void deleteDeptBydeptno(int deptno) {
		deptMapper.deleteDeptBydeptno(deptno);
	}

	@Override
	public void insertDept(Dept dept) {
		deptMapper.insertDept(dept);
	}

	@Override
	public void updateDeptBydeptno(Dept dept) {
		deptMapper.updateDeptBydeptno(dept);
	}
}
