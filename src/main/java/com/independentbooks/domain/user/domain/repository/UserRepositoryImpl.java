package com.independentbooks.domain.user.domain.repository;

import com.independentbooks.domain.user.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final EntityManager em;

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u")
                .getResultList();
    }

    @Override
    public User findUserById(Long id) {
        return em.find(User.class, id);
    }
}
