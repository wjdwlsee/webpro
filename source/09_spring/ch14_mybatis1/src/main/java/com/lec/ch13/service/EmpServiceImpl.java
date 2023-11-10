package com.lec.ch13.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch13.dao.DeptDao;
import com.lec.ch13.dao.EmpDao;
import com.lec.ch13.dto.Dept;
import com.lec.ch13.dto.Emp;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao empDao;
	@Autowired
	private DeptDao deptDao;
	@Override
	public List<Dept> deptList() {
		return deptDao.deptList();
	}
	@Override
	public List<Emp> empList(Emp schEmp) {
		//emp.do
		//emp.dp?ename=s&job=e&deptno=0=>schEmp.enmae이 "s"
		if(schEmp.getEname()!=null) {
			schEmp.setEname(schEmp.getEname().toUpperCase());
		}
		if(schEmp.getJob()!=null) {
			schEmp.setJob(schEmp.getJob().toUpperCase());	
		}
		return empDao.empList(schEmp);
	};

}
