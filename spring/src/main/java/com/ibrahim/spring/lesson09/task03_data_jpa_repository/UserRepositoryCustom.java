package com.ibrahim.spring.lesson09.task03_data_jpa_repository;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> search(UserSearchCriteria criteria);
}
