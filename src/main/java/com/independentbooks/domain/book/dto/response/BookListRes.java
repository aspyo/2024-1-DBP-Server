package com.independentbooks.domain.book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookListRes {
    // 표지,제목,가격
    private String bookCover;
    private String bookTitle;
    private int bookPrice;

}
