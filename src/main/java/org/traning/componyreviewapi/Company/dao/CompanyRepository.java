package org.traning.componyreviewapi.Company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.traning.componyreviewapi.Company.Job.Company;

//@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {



}
