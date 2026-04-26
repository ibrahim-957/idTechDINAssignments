package com.ibrahim.sixthmonth.mapper;

import com.ibrahim.sixthmonth.dao.entity.Course;
import com.ibrahim.sixthmonth.model.request.CreateCourseRequest;
import com.ibrahim.sixthmonth.model.response.CourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "students", ignore = true)
    Course toEntity(CreateCourseRequest request);

    CourseResponse toResponse(Course course);
}
