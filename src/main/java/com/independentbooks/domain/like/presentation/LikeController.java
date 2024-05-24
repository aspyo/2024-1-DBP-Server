package com.independentbooks.domain.like.presentation;

import com.independentbooks.domain.like.application.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/likes")
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/{bookId}")
    public ResponseEntity<?> createNewLike(
            @PathVariable Long bookId
    ) {
        return likeService.increaseLike(bookId);
    }

}
