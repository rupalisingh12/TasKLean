package com.TaskLeanPlatformTechnologies.demo.Dao;

import com.TaskLeanPlatformTechnologies.demo.Entity.Details;
import com.TaskLeanPlatformTechnologies.demo.Response.CreateTaskRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskDao extends JpaRepository<Details,String> {

  

    List<Details> findByAge(String age);
    List<Details>findByGender(String gender);

}
