package com.independentbooks.domain.user.application;


import com.independentbooks.domain.user.domain.User;
import com.independentbooks.domain.user.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void create(User user) {
        userRepository.save(user);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

}
