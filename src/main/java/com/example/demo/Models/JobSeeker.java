package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;



import java.util.*;

@Entity
@Table(name = "job_seeker")
public class JobSeeker extends User {
    private String resume;

    public JobSeeker() {}

    public JobSeeker(String name, String email, String username, Long externalId, String resume) {
        super(name, email, username, externalId);
        this.resume = resume;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}