package org.traning.componyreviewapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.traning.componyreviewapi.Job.Job;
import org.traning.componyreviewapi.Job.service.JobService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getJobs() {
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/Addjob")
    public ResponseEntity<String> addJob(@RequestBody Job job) {
        jobService.addJob(job);
        return ResponseEntity.ok("Job added successfully");
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJob(@PathVariable Long id) {
        Job JobbyId = jobService.findById(id);
        return JobbyId == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(JobbyId);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        Job JobbyId = jobService.findById(id);
        if (JobbyId == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        jobService.deleteJob(id);
        return ResponseEntity.ok("Job deleted successfully");
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job) {
//        Job JobbyId = jobService.findById(id);
//        if (JobbyId == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        jobService.deleteJob(id);
//        jobService.addJob(job);
        jobService.updateJob(id, job);
        return ResponseEntity.ok("Job updated successfully");
    }
}
