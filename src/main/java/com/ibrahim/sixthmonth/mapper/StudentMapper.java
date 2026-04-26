package com.ibrahim.sixthmonth.mapper;

import com.ibrahim.sixthmonth.dao.entity.Student;
import com.ibrahim.sixthmonth.model.request.CreateStudentRequest;
import com.ibrahim.sixthmonth.model.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "courses", ignore = true)
    Student toEntity(CreateStudentRequest request);

    StudentResponse toResponse(Student student);
}
