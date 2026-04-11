package com.ibrahim.spring.lesson09.task03_data_jpa_repository;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserSearchCriteria {
    private String usernamePrefix;
    private String emailDomain;
    private Boolean active;
    private Integer minLoginCount;
}
