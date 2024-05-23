package com.independentbooks.domain.book.application;

import com.independentbooks.domain.book.domain.Book;
import com.independentbooks.domain.book.domain.repository.BookRepository;
import com.independentbooks.domain.book.dto.response.BookDetailRes;
import com.independentbooks.domain.book.dto.response.BookListRes;
import com.independentbooks.domain.like.domain.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final LikeRepository likeRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<?> getBasicBooks() {
        List<Book> newBooks = getNewBooksList();
        List<Book> bestBooks = getBestBooksList();

        List<Book> allBooks = bookRepository.findAll();

        Set<Long> excludeIds = new HashSet<>();
        newBooks.forEach(book -> excludeIds.add(book.getBookId()));
        bestBooks.forEach(book -> excludeIds.add(book.getBookId()));

        List<Book> basicBooks = allBooks.stream()
                .filter(book -> !excludeIds.contains(book.getBookId()))
                .collect(Collectors.toList());

        List<BookListRes> bookListRes = basicBooks.stream()
                .map(b -> BookListRes.builder()
                        .bookId(b.getBookId())
                        .image(b.getImage())
                        .title(b.getTitle())
                        .price(b.getPrice())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(bookListRes);
    }


    @Transactional(readOnly = true)
    public ResponseEntity<?> getBestBooks() {
        List<Book> bestBooks = getBestBooksList();

        List<BookListRes> bookListRes = bestBooks.stream()
                .map(book -> BookListRes.builder()
                        .bookId(book.getBookId())
                        .image(book.getImage())
                        .title(book.getTitle())
                        .price(book.getPrice())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(bookListRes);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> getNewBooks() {
        List<Book> newBooks = getNewBooksList();

        List<BookListRes> bookListRes = newBooks.stream()
                .map(book -> BookListRes.builder()
                        .bookId(book.getBookId())
                        .image(book.getImage())
                        .title(book.getTitle())
                        .price(book.getPrice())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(bookListRes);
    }


    @Transactional(readOnly = true)
    public ResponseEntity<?> getBookDetail(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("해당 도서를 찾을 수 없습니다. ID: " + bookId));
        // 표지,제목,가격,줄거리,저자,출판사,출판일,ISBN,리뷰목록
        BookDetailRes bookDetailRes = BookDetailRes.builder()
                .image(book.getImage())
                .title(book.getTitle())
                .price(book.getPrice())
                .author(book.getAuthor())
                .summary(book.getBookInfo())
                .publisher(book.getPublisher())
                .pubDate(book.getPublishedDate().toString())
                .isbn(book.getIsbn())
                .reviews(book.getReviews())
                .build();

        return ResponseEntity.ok(bookDetailRes);

    }

    @Transactional(readOnly = true)
    public List<Book> getNewBooksList() {
        LocalDateTime threeMonthsAgo = LocalDateTime.now().minusMonths(3);
        return bookRepository.findAll().stream()
                .filter(b -> b.getPublishedDate().isAfter(threeMonthsAgo))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Book> getBestBooksList() {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);
        Pageable pageable = PageRequest.of(0, 5);  // 상위 5개 도서
        List<Object[]> results = likeRepository.findTopBooksByLikesWithinOneMonth(oneMonthAgo, pageable);

        return results.stream()
                .map(result -> (Book) result[0])
                .collect(Collectors.toList());
    }
}

