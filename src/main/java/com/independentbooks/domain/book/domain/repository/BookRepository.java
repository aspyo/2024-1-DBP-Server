package com.independentbooks.domain.book.domain.repository;

import com.independentbooks.domain.book.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookRepository {

    void save(Book book);

    List<Book> findAllBook();
}
