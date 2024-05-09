package com.independentbooks.domain.book.domain;

import com.independentbooks.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="Book")
@NoArgsConstructor
@Getter
public class Book extends BaseEntity {
    //book_id, title, publisher, isbn,book_info,price,published_date,image
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name="title", nullable = false) //도서 제목
    private String title;

    @Column(name="publisher", nullable = false) //출판사
    private String publisher;

    @Column(name="isbn", nullable = false, unique = true) //ISBN
    private String isbn;

    @Column(name="book_info", nullable = false) //도서 줄거리
    private String bookInfo;

    @Column(name="price", nullable = false) //도서 가격
    private int price;

    @Column(name="published_date", nullable = false) //출간일
    private LocalDateTime publishedDate;

    @Column(name="image", nullable = false) //도서 표지 이미지
    private String image;

    @Builder
    public Book(String title, String publisher, String isbn, String bookInfo, int price, LocalDateTime publishedDate, String image) {
        this.title = title;
        this.publisher = publisher;
        this.isbn = isbn;
        this.bookInfo = bookInfo;
        this.price = price;
        this.publishedDate = publishedDate;
        this.image = image;
    }
}
