package com.independentbooks.domain.review.domain;

import com.independentbooks.domain.book.domain.Book;
import com.independentbooks.domain.common.BaseEntity;
import com.independentbooks.domain.content.domain.Content;
import com.independentbooks.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Review")
@NoArgsConstructor
@Getter
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @Column(name="review_content", nullable = false)
    private String ReviewContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    private Content content;

    @Builder
    public Review(String reviewContent, Book book, User user, Content content) {
        ReviewContent = reviewContent;
        this.book = book;
        this.user = user;
        this.content = content;
    }

}
