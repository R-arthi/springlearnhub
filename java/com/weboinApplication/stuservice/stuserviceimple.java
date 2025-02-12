package com.weboinApplication.stuservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.weboinApplication.studentEntity.studententity;
import com.weboinApplication.studentrepo.sturepo;


@Service
public class stuserviceimple implements stuservice {
	@Autowired
	public sturepo sr;

	@Override
	public Integer savestu(studententity se) {
		return sr.save(se).getId();	
		}

	@Override
	public List<studententity>viewAll() {
		return sr.findAll();
	}

	@Override
	public void delete(Integer id) {
		sr.deleteById(id);
	}

	@Override
	public long gettotal() {
		long num = sr.count();
		return num;
	}

	@Override
	public long countbyColumn(String status) {
		long col1 = sr.countbyColumn(status);
		return col1;
	}

}
