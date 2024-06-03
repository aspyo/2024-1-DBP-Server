package com.independentbooks.domain.book.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewRes {
    private Long reviewId;
    private String reviewContent;
    private String userNickName;
}
