package com.ibrahim.sixthmonth.service;

import com.ibrahim.sixthmonth.dao.entity.Course;
import com.ibrahim.sixthmonth.dao.repository.CourseRepository;
import com.ibrahim.sixthmonth.mapper.CourseMapper;
import com.ibrahim.sixthmonth.model.request.CreateCourseRequest;
import com.ibrahim.sixthmonth.model.response.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Transactional
    public CourseResponse create(CreateCourseRequest request){
        Course course = courseMapper.toEntity(request);
        return courseMapper.toResponse(courseRepository.save(course));
    }

    public CourseResponse findById(Long id){
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return courseMapper.toResponse(course);
    }

    public List<CourseResponse> findAll(){
        return courseRepository.findAll().stream()
                .map(courseMapper::toResponse)
                .toList();
    }

    @Transactional
    public void deleteById(Long id){
        courseRepository.deleteById(id);
    }
}
