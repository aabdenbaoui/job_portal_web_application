package com.aabdenbaoui.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aabdenbaoui.management.entity.jobpost.JobPost;

@Repository
public interface IJobPostJpaRepository extends JpaRepository<JobPost, Long> {


}
