package com.independentbooks.domain.collection.domain;

import com.independentbooks.domain.user.domain.User;
import com.independentbooks.domain.book.domain.Book;
import com.independentbooks.domain.content.domain.Content;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Collection {

    @Id
    @GeneratedValue
    @Column(name = "collection_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    // Book과 N:N 관계
    @ManyToMany
    @JoinTable(
            name = "collection_book",
            joinColumns = @JoinColumn(name = "collection_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    private Content content;

    private String description;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedDate;

    //== 연관관계 메서드 ==//
    public void setUser(User user) {
        this.user = user;
        user.getCollections().add(this);
    }

    public void addBooks(Book book) {
        books.add(book);
        book.getCollections().add(this);
    }

    public void setContent(Content content) {
        this.content = content;
        content.getCollections().add(this);
    }

    // 생성 메서드
    public static Collection createCollection(User user, List<Book> books, Content content) {
        Collection collection = new Collection();
        collection.setUser(user);
        for (Book book : books) {
            collection.addBooks(book);
        }
        collection.setContent(content);

        return collection;
    }

    // 수정 메서드
    public void modify() {

    }

    // 삭제 메서드
    public void delete() {

    }
}
