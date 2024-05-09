package com.independentbooks.domain.user.domain;

import com.independentbooks.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="User")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="sign_up_id", nullable = false)
    private String signUpId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "withdrawal_date")
    private LocalDateTime WithdrawalDate;

    @Column(name = "is_withdrawal")
    private boolean isWithdrawal;

    @Builder
    public User(String signUpId, String name, String email, String password, String nickname, String phoneNumber, LocalDateTime withdrawalDate, boolean isWithdrawal) {
        this.signUpId = signUpId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.WithdrawalDate = withdrawalDate;
        this.isWithdrawal = isWithdrawal;
    }

}
