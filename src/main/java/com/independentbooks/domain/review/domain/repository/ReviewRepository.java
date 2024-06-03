package com.independentbooks.domain.review.domain.repository;

import com.independentbooks.domain.book.domain.Book;
import com.independentbooks.domain.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
    //List<Review> findByBookId(Long bookId);

    List<Review> findAllByBook(Book book);
    //List<Review> findAllByBookId(Long bookId);
}

