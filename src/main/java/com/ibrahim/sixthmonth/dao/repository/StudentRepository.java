package com.ibrahim.sixthmonth.dao.repository;

import com.ibrahim.sixthmonth.dao.entity.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByName(String name);

    @EntityGraph(attributePaths = "courses")
    List<Student> findAll();
}
