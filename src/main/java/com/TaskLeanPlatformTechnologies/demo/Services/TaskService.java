package com.TaskLeanPlatformTechnologies.demo.Services;

import com.TaskLeanPlatformTechnologies.demo.Entity.Details;
import com.TaskLeanPlatformTechnologies.demo.Model.TaskRequest;
import com.TaskLeanPlatformTechnologies.demo.Response.CreateTaskRequest;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    public CreateTaskRequest addDetails(TaskRequest taskRequest);
    public List<Details> getDetails(String age, String gender);
}
