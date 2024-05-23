package com.independentbooks.domain.book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookListRes {
    // 표지,제목,가격
    private Long bookId;
    private String image;
    private String title;
    private Long price;
}
