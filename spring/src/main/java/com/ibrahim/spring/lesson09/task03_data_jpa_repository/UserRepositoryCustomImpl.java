package com.ibrahim.spring.lesson09.task03_data_jpa_repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> search(UserSearchCriteria criteria) {
        log.info("[CustomRepo] Building dynamic query for criteria: {}", criteria);

        List<String> conditions = new ArrayList<>();

        if (criteria.getUsernamePrefix() != null) {
            conditions.add("u.username LIKE :usernamePrefix");
        }
        if (criteria.getEmailDomain() != null) {
            conditions.add("u.email LIKE :emailDomain");
        }
        if (criteria.getActive() != null) {
            conditions.add("u.active = :active");
        }
        if (criteria.getMinLoginCount() != null) {
            conditions.add("u.loginCount >= :minLoginCount");
        }

        String jpql = "SELECT u FROM User u"
                + (conditions.isEmpty() ? "" : " WHERE " + String.join(" AND ", conditions))
                + " ORDER BY u.username ASC";

        log.info("[CustomRepo] Generated JPQL: {}", jpql);

        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);

        if (criteria.getUsernamePrefix() != null) {
            query.setParameter("usernamePrefix", criteria.getUsernamePrefix() + "%");
        }
        if (criteria.getEmailDomain() != null) {
            query.setParameter("emailDomain", "%" + criteria.getEmailDomain());
        }
        if (criteria.getActive() != null) {
            query.setParameter("active", criteria.getActive());
        }
        if (criteria.getMinLoginCount() != null) {
            query.setParameter("minLoginCount", criteria.getMinLoginCount());
        }

        List<User> results = query.getResultList();
        log.info("[CustomRepo] Found {} users matching criteria", results.size());
        return results;
    }
}
