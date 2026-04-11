package com.ibrahim.simpleshop.mapper;

import com.ibrahim.simpleshop.dao.entity.User;
import com.ibrahim.simpleshop.model.request.CreateUserRequest;
import com.ibrahim.simpleshop.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    User toEntity(CreateUserRequest request);

    UserResponse toResponse(User user);
}
