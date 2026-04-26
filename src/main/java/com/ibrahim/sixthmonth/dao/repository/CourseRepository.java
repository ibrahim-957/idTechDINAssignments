package com.ibrahim.sixthmonth.dao.repository;

import com.ibrahim.sixthmonth.dao.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
