package com.lec.ch13.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.theme.SessionThemeResolver;

import com.lec.ch13.dto.Emp;
@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	@Override
	public List<Emp> empList(Emp schEmp) {
		return sessionTemplate.selectList("empList",schEmp);
	}

}
