package com.independentbooks.domain.collection.domain.repository;

import com.independentbooks.domain.collection.domain.Collection;
import com.independentbooks.domain.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface CollectionRepository {

    // 컬렉션 저장 메서드
    void save(Collection collection);

    // 컬렉션 조회 메서드
    Collection findCollection(Long id);

    // 모든 컬렉션 조회 메서드
    List<Collection> findAllCollection();

    // 특정 유저의 모든 컬렉션 조회 메서드
    List<Collection> findAllByUser(User user);

    // 컬렉션 수정 메서드
    void modifyCollection(Collection collection);

    // 컬렉션 제거 메서드
    void deleteCollection(Collection collection);

}
