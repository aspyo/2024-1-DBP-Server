package com.independentbooks.domain.book.domain.repository;

import com.independentbooks.domain.book.domain.Book;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final EntityManager em;
    @Override
    public void save(Book book) {
        em.persist(book);
    }

    @Override
    public List<Book> findAllBook() {
        return em.createQuery("select b from Book b", Book.class)
                .getResultList();
    }
}
