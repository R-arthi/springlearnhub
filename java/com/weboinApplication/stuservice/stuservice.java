package com.weboinApplication.stuservice;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.weboinApplication.studentEntity.studententity;

public interface stuservice {
Integer savestu(studententity se);
List<studententity> viewAll();
void delete(Integer id);
public long gettotal();
@Query("Select count(c) from studententity c where c.status= :status")
long countbyColumn(@Param("status")  String status);

}