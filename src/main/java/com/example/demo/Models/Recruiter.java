package com.example.demo.Models;

import jakarta.persistence.*;


@Entity
@Table(name = "recruiter")
public class Recruiter extends User {
    private String companyName;

    public Recruiter() {}

    public Recruiter(String name, String email, String username, Long externalId, String companyName) {
        super(name, email, username, externalId);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}