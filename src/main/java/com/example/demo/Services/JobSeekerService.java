package com.example.demo.Services;

import com.example.demo.Models.JobSeeker;
import com.example.demo.Repos.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerRepository.findAll();
    }

    public Optional<JobSeeker> getJobSeekerById(UUID id) {
        return jobSeekerRepository.findById(id);
    }

    public JobSeeker saveJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerRepository.save(jobSeeker);
    }

    public void deleteJobSeeker(UUID id) {
        jobSeekerRepository.deleteById(id);
    }
}