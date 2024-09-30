package com.example.demo.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "recruiter")
public class Recruiter extends User {

    @Column(name = "company_name", nullable = false)
    private String companyName;


    public Recruiter() {}

    public Recruiter(String name, String email, String username, Long externalId, String companyName, String password) {
        super(name, email, username, externalId, password);
        this.companyName = companyName;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
