//package com.independentbooks.collection;
//
//import com.independentbooks.domain.book.domain.Book;
//import com.independentbooks.domain.collection.domain.Collection;
//import com.independentbooks.domain.content.domain.Content;
//import com.independentbooks.domain.content.domain.ContentType;
//import com.independentbooks.domain.user.domain.User;
//import jakarta.persistence.EntityManager;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Commit;
//import org.springframework.transaction.annotation.Transactional;
//
//@SpringBootTest
//@Transactional
//public class CollectionEntityTest {
//
//    @Autowired
//    EntityManager em;
//
//    @Test
//    @Commit
//    void collectionCreateTest() {
//        User user = new User();
//        user.setName("userA");
//        em.persist(user);
//
//        Content content = new Content();
//        content.setContentType(ContentType.COLLECTION);
//        em.persist(content);
//
//        Book book = new Book();
//        book.setTitle("Spring JPA");
//        em.persist(book);
//
//        Collection collection = Collection.createCollection(user, content, "테스트 북", book);
//        em.persist(collection);
//    }
//}
