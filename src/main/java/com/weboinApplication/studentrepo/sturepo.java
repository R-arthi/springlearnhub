package com.weboinApplication.studentrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.weboinApplication.studentEntity.studententity;

public interface sturepo extends JpaRepository<studententity, Integer> {

	@Query("Select count(c) from studententity c where c.status= :status")
	long countbyColumn(@Param("status")  String status);

}
