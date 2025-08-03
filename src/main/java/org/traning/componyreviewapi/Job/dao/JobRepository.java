package org.traning.componyreviewapi.Job.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.traning.componyreviewapi.Job.Job;

//@Repository
public interface JobRepository extends JpaRepository<Job, Long> {



}
