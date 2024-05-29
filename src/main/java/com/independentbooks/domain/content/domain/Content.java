package com.independentbooks.domain.content.domain;

import com.independentbooks.domain.review.domain.Review;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="Content")
@NoArgsConstructor
@Getter
@Setter
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Long contentId;

    @Column(name="content_type", nullable = false)
    private ContentType contentType;

    @OneToMany(mappedBy = "content")
    private List<Review> reviews;
  
  //    @OneToMany(mappedBy = "content")
//    private List<Collection> collections = new ArrayList<>();

    @Builder
    public Content(ContentType contentType) {
        this.contentType = contentType;
    }
}
