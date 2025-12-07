package com.els.supabasemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.els.supabasemanager.controllers.Errors.NotFoundException;
import com.els.supabasemanager.db.entities.JobPost;
import com.els.supabasemanager.db.repositories.JobPostRepository;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/jobs")
public class JobPostController {

    @Autowired
    JobPostRepository jobPostRepository;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<JobPost> getJobs() {
        List<JobPost> jobs = this.jobPostRepository.findAll();
        return jobs;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public JobPost getJobById(@PathVariable String id) {
        var job = this.jobPostRepository.findById(Long.parseLong(id));
        if (job.isEmpty()) {
            throw new NotFoundException("Job with id " + id + " not found");
        }
        return job.get();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void postMethodName(@RequestBody JobPost posting) {
        this.jobPostRepository.save(posting);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void putMethodName(@PathVariable String id, @RequestBody JobPost posting) {
        posting.setId(Long.parseLong(id));
        if (this.jobPostRepository.findById(Long.parseLong(id)).isEmpty()) {
            throw new NotFoundException("Job with id " + id + " not found, it cannot be updated");
        }

        this.jobPostRepository.save(posting);
    }

}
