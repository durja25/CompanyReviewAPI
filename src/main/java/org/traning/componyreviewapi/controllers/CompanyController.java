package org.traning.componyreviewapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.traning.componyreviewapi.Company.Job.Company;
import org.traning.componyreviewapi.Company.service.CompanyService;

import java.util.List;

@RestController("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getCompanies")
    public ResponseEntity<List<Company>> getJobs() {
        return ResponseEntity.ok(companyService.findAll());
    }

    @PostMapping("/Addcompany")
    public ResponseEntity<String> addCompany(@RequestBody Company job) {
        companyService.addCompany(job);
        return ResponseEntity.ok("Job added successfully");
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {
        Company JobbyId = companyService.findById(id);
        return JobbyId == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(JobbyId);
    }

    @DeleteMapping("/company/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        Company JobbyId = companyService.findById(id);
        if (JobbyId == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        companyService.deleteCompany(id);
        return ResponseEntity.ok("Job deleted successfully");
    }

    @PutMapping("/company/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
//        Job JobbyId = jobService.findById(id);
//        if (JobbyId == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        jobService.deleteJob(id);
//        jobService.addJob(company);
        companyService.updateCompany(id, company);
        return ResponseEntity.ok("Job updated successfully");
    }
}
