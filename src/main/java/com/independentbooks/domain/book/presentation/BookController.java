package com.independentbooks.domain.book.presentation;

import com.independentbooks.domain.book.application.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;

    //기본 도서 목록 조회
    @GetMapping("/basic")
    public ResponseEntity<?> getBooks() {
        return ResponseEntity.ok(bookService.getBasicBooks());
    }

    @GetMapping("/best")
    public ResponseEntity<?> getBestBooks() {
        return ResponseEntity.ok(bookService.getBestBooks());
    }

    @GetMapping("/new")
    public ResponseEntity<?> getNewBooks() {
        return ResponseEntity.ok(bookService.getNewBooks());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookDetail(
            @PathVariable Long bookId
    ) {
        return ResponseEntity.ok(bookService.getBookDetail(bookId));
    }

}
