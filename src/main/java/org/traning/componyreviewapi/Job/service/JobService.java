package org.traning.componyreviewapi.Job.service;

import org.traning.componyreviewapi.Job.Job;

import java.util.List;

public interface JobService {

    public List<Job> findAll();

    public void addJob(Job job);

    public Job findById(Long id);

    public void deleteJob(Long id);

    public void updateJob(Long id, Job job);
}
