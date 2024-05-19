package com.independentbooks.domain.book.domain;

import com.independentbooks.domain.collection.domain.Collection;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    private String title;

    // 컬렉션과 N:N 관계
//    @ManyToMany(mappedBy = "books")
//    private List<Collection> collections = new ArrayList<>();
}
