package org.traning.componyreviewapi.Company.service;

import org.traning.componyreviewapi.Company.Job.Company;

import java.util.List;

public interface CompanyService {

    public List<Company> findAll();

    public void addCompany(Company job);

    public Company findById(Long id);

    public void deleteCompany(Long id);

    public void updateCompany(Long id, Company company);
}
