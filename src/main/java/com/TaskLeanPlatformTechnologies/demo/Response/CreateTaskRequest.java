package com.TaskLeanPlatformTechnologies.demo.Response;

import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
@Data
public class CreateTaskRequest {

    private String userId;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;

    public Timestamp invoiceTimestamp;
    private String age;
    private String gender;
}
