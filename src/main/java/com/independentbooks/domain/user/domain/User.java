package com.independentbooks.domain.user.domain;

import com.independentbooks.domain.collection.domain.Collection;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;

//    // Collection 과 1:N 관계
//    @OneToMany(mappedBy = "user")
//    private List<Collection> collections = new ArrayList<>();
}
