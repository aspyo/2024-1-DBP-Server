package com.independentbooks.domain.user.domain.repository;

import com.independentbooks.domain.user.domain.User;

import java.util.List;

public interface UserRepository {

    void save(User user);

    List<User> findAll();

    User findUserById(Long id);
}
