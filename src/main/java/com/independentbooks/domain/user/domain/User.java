package com.independentbooks.domain.user.domain;


import com.independentbooks.domain.common.BaseEntity;
import com.independentbooks.domain.like.domain.Like;
import com.independentbooks.domain.review.domain.Review;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="User")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

//    @Column(name="sign_up_id")
//    private String signUpId;
//
    @Column(name="name")
    private String name;
//
//    @Column(name="email")
//    private String email;
//
//    @Column(name = "password")
//    private String password;
//
    @Column(name = "nickname")
    private String nickname;
//
//    @Column(name = "phone_number")
//    private String phoneNumber;
//
//    @Column(name = "withdrawal_date")
//    private LocalDateTime WithdrawalDate;
//
//    @Column(name = "is_withdrawal")
//    private boolean isWithdrawal;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<Like> likes;
  
  //    // Collection 과 1:N 관계
//    @OneToMany(mappedBy = "user")
//    private List<Collection> collections = new ArrayList<>();

    @Builder
    public User(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

}