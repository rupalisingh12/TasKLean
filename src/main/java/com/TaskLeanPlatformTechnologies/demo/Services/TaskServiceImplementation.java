package com.TaskLeanPlatformTechnologies.demo.Services;

import com.TaskLeanPlatformTechnologies.demo.Dao.TaskDao;
import com.TaskLeanPlatformTechnologies.demo.Entity.Details;
import com.TaskLeanPlatformTechnologies.demo.Model.TaskRequest;
import com.TaskLeanPlatformTechnologies.demo.Response.CreateTaskRequest;
import io.micrometer.common.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class TaskServiceImplementation implements TaskService {

    TaskDao taskDao;
    @Autowired
    public TaskServiceImplementation(TaskDao taskDao){
        this.taskDao=taskDao;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public CreateTaskRequest addDetails(TaskRequest taskRequest){
        log.info("addDetails started");
        String temp="";
        Details details=new Details();
        CreateTaskRequest createTaskRequest=new CreateTaskRequest();
        temp="UserId:"+ UUID.randomUUID();
        details.setUserId(temp);
        createTaskRequest.setUserId(temp);
        temp=taskRequest.getFirstName();
        if (StringUtils.isNotBlank(temp)) {
            details.setFirstName(temp);
            createTaskRequest.setFirstName(temp);
        }
        temp=taskRequest.getLastName();
        if(StringUtils.isNotBlank(temp)){
            details.setLastName(temp);
            createTaskRequest.setLastName(temp);
        }
        temp=taskRequest.getAge();
        if(StringUtils.isNotBlank(temp)){
            details.setAge(temp);
            createTaskRequest.setAge(temp);
        }
        temp=taskRequest.getEmail();
        if(StringUtils.isNotBlank(temp)){
            details.setEmail(temp);
            createTaskRequest.setEmail(temp);
        }
        temp=taskRequest.getGender();
        if(StringUtils.isNotBlank(temp)){
            details.setGender(temp);
            createTaskRequest.setGender(temp);
        }
        temp = taskRequest.getAge();
        if (StringUtils.isNotBlank(temp)) {
            // Check if the age is above 27 before setting it
            int age = Integer.parseInt(temp);
            if (age > 27) {
                details.setAge(temp);
                createTaskRequest.setAge(temp);
            } else {
                // If the age is 27 or below, you can handle it accordingly (e.g., throw an exception, log a message, etc.)
                throw new IllegalArgumentException("User age must be above 27.");
                // You may choose to return an appropriate response or throw an exception here.
            }
        }
        temp=taskRequest.getPhoneNo();
        if(StringUtils.isNotBlank(temp)) {
            details.setPhoneNo(temp);
            createTaskRequest.setPhoneNo(temp);
        }
        taskDao.save(details);
        return createTaskRequest;



    }

    @Override
    public List<Details> getDetails(String age, String gender) {
        log.info("getDetails services with params started");
        List<Details> listans = null;
        if(age!=null){
            listans = taskDao.findByAge(age);
            return listans;
        }
        if(gender!=null){
            listans= taskDao.findByGender(gender);
            return listans;

        }
        return listans;


    }

}
