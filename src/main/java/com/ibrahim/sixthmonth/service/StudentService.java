package com.ibrahim.sixthmonth.service;

import com.ibrahim.sixthmonth.dao.entity.Course;
import com.ibrahim.sixthmonth.dao.entity.Student;
import com.ibrahim.sixthmonth.dao.repository.CourseRepository;
import com.ibrahim.sixthmonth.dao.repository.StudentRepository;
import com.ibrahim.sixthmonth.mapper.StudentMapper;
import com.ibrahim.sixthmonth.model.request.CreateStudentRequest;
import com.ibrahim.sixthmonth.model.request.DropCourseRequest;
import com.ibrahim.sixthmonth.model.request.TakeCourseRequest;
import com.ibrahim.sixthmonth.model.response.StudentResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final EntityManager em;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentMapper studentMapper;

    public List<StudentResponse> findStudentsOlderThan20(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);

        cq.select(root)
                .where(cb.greaterThanOrEqualTo(root.get("age"), 20));

        return em.createQuery(cq).getResultList().stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    @Transactional
    public StudentResponse createStudent(CreateStudentRequest request){
        Student student =  studentMapper.toEntity(request);
        return studentMapper.toResponse(studentRepository.save(student));
    }

    public List<StudentResponse> findAllStudents(){
        return studentRepository.findAll().stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    public StudentResponse findById(Long id){
        return studentMapper.toResponse(findStudentById(id));
    }

    @Transactional
    public StudentResponse takeCourse(Long studentId, TakeCourseRequest request){
        Student student = findStudentById(studentId);
        Course course = findCourseById(request.getCourseId());

        if (student.getCourses().contains(course)){
            throw new IllegalStateException("Course is already taken");
        }

        student.getCourses().add(course);
        return studentMapper.toResponse(studentRepository.save(student));
    }

    @Transactional
    public StudentResponse dropCourse(Long studentId, DropCourseRequest request){
        Student student = findStudentById(studentId);
        Course course = findCourseById(request.getCourseId());

        if (!student.getCourses().contains(course)){
            throw new IllegalStateException("Course is not taken");
        }

        student.getCourses().remove(course);
        return studentMapper.toResponse(studentRepository.save(student));
    }

    private Student findStudentById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    private Course findCourseById(Long id){
        return  courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }
}
