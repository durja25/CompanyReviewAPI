package org.traning.componyreviewapi.Company.service;

import org.springframework.stereotype.Service;
import org.traning.componyreviewapi.Company.Job.Company;
import org.traning.componyreviewapi.Company.dao.CompanyRepository;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository jobRepository) {
        this.companyRepository = jobRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void addCompany(Company job) {
        companyRepository.save(job);
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(new Company());
    }

    @Override
    public void deleteCompany(Long id) {

        companyRepository.findById(id).ifPresent(job -> companyRepository.delete(job));
    }

    @Override
    public void updateCompany(Long id, Company company) {
        companyRepository.findById(id).ifPresent(job1 -> {
            job1.setName(company.getName());
            job1.setDescription(company.getDescription());
            job1.setJobs(company.getJobs());
            companyRepository.save(job1);
        });
//        jobRepository.
    }

}
