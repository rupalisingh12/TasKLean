package com.TaskLeanPlatformTechnologies.demo.Controller;

import com.TaskLeanPlatformTechnologies.demo.Model.TaskRequest;
import com.TaskLeanPlatformTechnologies.demo.Services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {
    private TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }
    @PostMapping
    public ResponseEntity<Object>PostDetails(@RequestBody TaskRequest taskRequest) {
        log.info("Details method started successfully");
        return new ResponseEntity<Object>(taskService.addDetails(taskRequest), HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<Object>GetDetails(@RequestParam(name="age",required = false)String age,
                                            @RequestParam(name="gender",required = false)String gender){
        return new ResponseEntity<>(taskService.getDetails(age,gender), HttpStatus.OK);
    }

}
