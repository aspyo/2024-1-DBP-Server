package com.independentbooks.domain.collection.application;

import com.independentbooks.domain.book.domain.Book;
import com.independentbooks.domain.collection.domain.Collection;
import com.independentbooks.domain.collection.domain.repository.CollectionRepository;
import com.independentbooks.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CollectionService {

    private final CollectionRepository collectionRepository;

    // 컬렉션 생성
    public void create(Collection collection) {
        collectionRepository.save(collection);
    }

    // 모든 컬렉션 조회
    public List<Collection> findAll() {
        return collectionRepository.findAllCollection();
    }

    // 특정 유저의 컬렉션 조회
    public List<Collection> findAllByUser(User user) {
        return collectionRepository.findAllByUser(user);
    }

    // 컬렉션 수정
    public void modify(Long id, String newDescription, List<Book> books) {
        Collection findCollection = collectionRepository.findCollection(id);
        findCollection.setDescription(newDescription);
        findCollection.setBooks(books);
    }

    // 컬렉션 삭제
    public void delete(Collection collection) {
        collectionRepository.deleteCollection(collection);
    }

}
