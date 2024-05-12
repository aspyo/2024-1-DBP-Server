package com.independentbooks.domain.content.domain;

import com.independentbooks.domain.collection.domain.Collection;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Content {

    @Id @GeneratedValue
    @Column(name = "content_id")
    private Long id;

    @OneToMany(mappedBy = "content")
    private List<Collection> collections = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private ContentType contentType;
}
