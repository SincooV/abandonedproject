package com.example.demo.Controllers;

import com.example.demo.Models.JobSeeker;
import com.example.demo.Services.JobSeekerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/jobseekers")
public class JobSeekerController {


    private final JobSeekerService jobSeekerService;

    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping
    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerService.getAllJobSeekers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobSeeker> getJobSeekerById(@PathVariable UUID id) {
        Optional<JobSeeker> jobSeeker = jobSeekerService.getJobSeekerById(id);
        return jobSeeker.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public JobSeeker createJobSeeker(@RequestBody JobSeeker jobSeeker) {
        return jobSeekerService.saveJobSeeker(jobSeeker);
    }
    @PutMapping("/{id}")
    public ResponseEntity<JobSeeker> updateJobSeeker(@PathVariable UUID id, @RequestBody JobSeeker jobSeekerDetails) {
        Optional<JobSeeker> jobSeeker = jobSeekerService.getJobSeekerById(id);
        if (jobSeeker.isPresent()) {
            JobSeeker updatedJobSeeker = jobSeeker.get();
            updatedJobSeeker.setName(jobSeekerDetails.getName());
            updatedJobSeeker.setEmail(jobSeekerDetails.getEmail());
            updatedJobSeeker.setUsername(jobSeekerDetails.getUsername());
            updatedJobSeeker.setResume(jobSeekerDetails.getResume());
            return ResponseEntity.ok(jobSeekerService.saveJobSeeker(updatedJobSeeker));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<JobSeeker> partialUpdateJobSeeker(@PathVariable UUID id, @RequestBody JobSeeker jobSeekerDetails) {
        Optional<JobSeeker> jobSeeker = jobSeekerService.getJobSeekerById(id);
        if (jobSeeker.isPresent()) {
            JobSeeker updatedJobSeeker = jobSeeker.get();
            if (jobSeekerDetails.getName() != null) updatedJobSeeker.setName(jobSeekerDetails.getName());
            if (jobSeekerDetails.getEmail() != null) updatedJobSeeker.setEmail(jobSeekerDetails.getEmail());
            if (jobSeekerDetails.getUsername() != null) updatedJobSeeker.setUsername(jobSeekerDetails.getUsername());
            if (jobSeekerDetails.getResume() != null) updatedJobSeeker.setResume(jobSeekerDetails.getResume());
            return ResponseEntity.ok(jobSeekerService.saveJobSeeker(updatedJobSeeker));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginJobSeeker(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email,
            @RequestParam String password) {


        if (username == null && email == null) {
            return ResponseEntity.badRequest().body("Username or email is required");
        }
        return ResponseEntity.ok("Login successful");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobSeeker(@PathVariable UUID id) {
        jobSeekerService.deleteJobSeeker(id);
        return ResponseEntity.noContent().build();
    }

}
