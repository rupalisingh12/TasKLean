package com.TaskLeanPlatformTechnologies.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
public class Details {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    @CreationTimestamp
    public Timestamp invoiceTimestamp;
    private String age;
    private String gender;
}
