package com.ibrahim.spring.assetmanagement.specification;

import com.ibrahim.spring.assetmanagement.entity.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {
    private EmployeeSpecification(){}

    public static Specification<Employee> hasFirstName(String firstName){
        return (root, query, cb) ->
                firstName == null ? null :
                        cb.like(cb.lower(root.get("firstName")),
                                "%" + firstName.toLowerCase() + "%");
    }

    public static Specification<Employee> hasLastName(String lastName){
        return (root, query, cb) ->
                lastName == null ? null
                        : cb.like(cb.lower(root.get("lastName")),
                        lastName.toLowerCase() + "%");
    }

    public static Specification<Employee> hadDepartment(Long departmentId){
        return (root, query, cb) ->
                departmentId == null ? null :
                        cb.equal(root.get("department").get("id"),
                                departmentId);
    }

    public static Specification<Employee> isActive(Boolean active){
        return (root, query, cb) ->
                active == null ? null
                        : cb.equal(root.get("active"), active);
    }
}
