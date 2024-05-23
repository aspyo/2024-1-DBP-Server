package com.independentbooks.domain.collection.presentation;

import com.independentbooks.domain.book.application.BookService;
import com.independentbooks.domain.book.domain.Book;
import com.independentbooks.domain.collection.application.CollectionService;
import com.independentbooks.domain.collection.domain.Collection;
import com.independentbooks.domain.user.application.UserService;
import com.independentbooks.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;
    private final BookService bookService;
    private final UserService userService;

    // 모든 컬렉션 조회
    @GetMapping("/collections")
    public String list(Model model) {
        List<Collection> collections = collectionService.findAll();
        model.addAttribute("collections", collections);

        return "collections/collectionList";
    }

    // Id가 1인 유저의 컬렉션 조회
    @GetMapping("/collections/1")
    public String userCollection(Model model) {
        User findUser = userService.findUserById(1L);
        List<Collection> collections = collectionService.findAllByUser(findUser);
        model.addAttribute("collections",collections);

        return "collections/userCollectionList";
    }

//    // 컬렉션 생성 버튼 클릭시
//    @GetMapping("/collections/new")
//    public String createForm(Model model) {
//        List<Book> books = bookService.findAll();
//        model.addAttribute("books", books);
//
//        return "collections/collectionForm";
//    }
//
//    // 컬렉션 생성 완료 버튼 클릭시
//    @PostMapping("/collections/new")
//    public String create(@RequestParam("books") List<Book> books,
//                         @RequestParam("description") String description) {
//        collectionService.create();
//    }
}
