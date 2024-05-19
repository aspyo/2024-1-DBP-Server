package com.independentbooks.collection;

import com.independentbooks.domain.book.domain.Book;
import com.independentbooks.domain.collection.application.CollectionService;
import com.independentbooks.domain.collection.domain.Collection;
import com.independentbooks.domain.collection.domain.repository.CollectionRepository;
import com.independentbooks.domain.content.domain.Content;
import com.independentbooks.domain.content.domain.ContentType;
import com.independentbooks.domain.user.domain.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class CollectionServiceTest {

    @Autowired
    CollectionService collectionService;

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    EntityManager em;

    // 테스트 성공
    @Test
    @Commit
    public void 컬렉션생성() {
        User user = new User();
        user.setName("helloA");
        em.persist(user);

        Content content = new Content();
        content.setContentType(ContentType.COLLECTION);
        em.persist(content);

        String description = "테스트 컬렉션1 입니다.";
        String description2 = "테스트 컬렉션2 입니다.";

        Book book1 = new Book();
        book1.setTitle("Test Book 1");
        Book book2 = new Book();
        book2.setTitle("Test Book 2");
        em.persist(book1);
        em.persist(book2);

        Collection newCollection = Collection.createCollection(user, content, description, book1, book2);
        collectionService.create(newCollection);
        Collection newCollection2 = Collection.createCollection(user, content, description2, book1, book2);
        collectionService.create(newCollection2);
    }

    //테스트 성공
    @Test
    public void 특정유저의_컬렉션조회() {
        User findUser = em.find(User.class, 1);
        List<Collection> collections = collectionService.findAllByUser(findUser);
        List<Book> books;
        for (Collection c : collections) {
            System.out.println("출력 테스트입니다.");
            System.out.println("Collection Id:" + c.getId());
            System.out.println("Collection description:" + c.getDescription());
            books = c.getBooks();
            for (Book b : books) {
                System.out.println("타이틀 = " + b.getTitle());
            }
        }
    }

    //테스트 성공
    @Test
    @Commit
    public void 컬렉션삭제() {
        Collection findCollection = em.find(Collection.class, 1);
        collectionService.delete(findCollection);
    }

    //테스트 성공
    @Test
    @Commit
    public void 컬렉션수정() {
        Book book1 = new Book();
        book1.setTitle("수정된 Book 1");
        Book book2 = new Book();
        book2.setTitle("수정된 Book 2");
        em.persist(book1);
        em.persist(book2);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        collectionService.modify(2L, "수정한 description 입니다.", books);
    }
}
