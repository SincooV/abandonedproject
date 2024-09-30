package com.example.demo.Repos;

import com.example.demo.Models.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, UUID> {

}