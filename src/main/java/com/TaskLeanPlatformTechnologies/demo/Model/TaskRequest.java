package com.TaskLeanPlatformTechnologies.demo.Model;

import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
@Data
public class TaskRequest {

    private String userId;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;

    public Timestamp invoiceTimestamp;
    private String age;
    private String gender;
}
