package com.independentbooks.domain.collection.domain.repository;
import com.independentbooks.domain.collection.domain.Collection;
import com.independentbooks.domain.user.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class JPACollectionRepository implements CollectionRepository {

    private final EntityManager em;

    // 컬렉션 저장 메서드
    @Override
    public void save(Collection collection) {
        em.persist(collection);
    }

    // id로 컬렉션 조회 메서드
    @Override
    public Collection findCollection(Long id) {
        return em.find(Collection.class, id);
    }

    // 모든 컬렉션 조회 메서드
    @Override
    public List<Collection> findAllCollection() {
        return em.createQuery("select c from Collection c", Collection.class).getResultList();
    }

    // 특정 유저의 모든 컬렉션 조회 메서드
    @Override
    public List<Collection> findAllByUser(User user) {
        return em.createQuery("select c from Collection c where c.user = :user", Collection.class)
                .setParameter("user", user)
                .getResultList();
    }

    // 컬렉션 수정 메서드
    @Override
    public void modifyCollection(Collection collection) {

    }

    // 컬렉션 삭제 메서드
    @Override
    public void deleteCollection(Collection collection) {
        em.remove(collection);
    }
}
