package com.els.supabasemanager.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.els.supabasemanager.db.entities.JobPost;

public interface JobPostRepository extends JpaRepository<JobPost, Long> {
}