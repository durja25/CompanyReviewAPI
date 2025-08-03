package org.traning.componyreviewapi.Job.service;

import org.springframework.stereotype.Service;
import org.traning.componyreviewapi.Job.Job;
import org.traning.componyreviewapi.Job.dao.JobRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void addJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job findById(Long id) {
        return jobRepository.findById(id).orElse(new Job());
    }

    @Override
    public void deleteJob(Long id) {

        jobRepository.findById(id).ifPresent(job -> jobRepository.delete(job));
    }

    @Override
    public void updateJob(Long id, Job job) {
        jobRepository.findById(id).ifPresent(job1 -> {
            job1.setTitle(job.getTitle());
            job1.setDescription(job.getDescription());
            job1.setLocation(job.getLocation());
            job1.setMinSalary(job.getMinSalary());
            job1.setMaxSalary(job.getMaxSalary());
            jobRepository.save(job1);
        });
//        jobRepository.
    }

}
