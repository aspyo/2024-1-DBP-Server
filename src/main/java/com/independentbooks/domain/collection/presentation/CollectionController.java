package com.independentbooks.domain.collection.presentation;

import com.independentbooks.domain.book.application.BookService;
import com.independentbooks.domain.book.domain.Book;
import com.independentbooks.domain.collection.application.CollectionService;
import com.independentbooks.domain.collection.domain.Collection;
import com.independentbooks.domain.content.domain.Content;
import com.independentbooks.domain.content.domain.ContentType;
import com.independentbooks.domain.user.application.UserService;
import com.independentbooks.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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
        User findUser = userService.findUserById(1L).orElse(null); // 값이 없으면 null 반환
        List<Collection> collections = collectionService.findAllByUser(findUser);
        model.addAttribute("collections",collections);

        return "collections/userCollectionList";
    }

    // 컬렉션 생성 버튼 클릭시 생성 폼을 보여줌
    @GetMapping("/collections/new")
    public String createForm(Model model) {

        //컬렉션에 포함시키기 위한 모든 책 데이터 조회
        List<Book> books = bookService.findAll();

        model.addAttribute("books", books);

        return "collections/collectionForm";
    }

    // 컬렉션 생성 완료 버튼 클릭시
    @PostMapping("/collections/new")
    public String create(@ModelAttribute("books") List<Book> books,
                         @RequestParam("description") String description) {

        // ID가 1인 유저 조회
        User findUser = userService.findUserById(1L).orElse(null);

        Content content = new Content(ContentType.COLLECTION);

        Collection collection = Collection.createCollection(findUser, content, "테스트 컬렉션입니다.", books);

        collectionService.create(collection);

        return "redirect:/collections";
    }

    // 컬렉션 수정 버튼 클릭시 수정 폼을 보여줌
    @GetMapping("/collections/modify")
    public String modifyForm(@RequestParam("id") Long id, Model model) {
        Collection collection = collectionService.findById(id);
        List<Book> books = bookService.findAll();
        model.addAttribute("collection", collection);
        model.addAttribute("books", books);

        return "collections/editForm";
    }

    // 컬렉션 수정 완료 버튼 클릭시
    @PostMapping("/collections/modify")
    public String modify(@ModelAttribute("collection") Collection collection,
                         @ModelAttribute("books") List<Book> books,
                         @RequestParam("description") String description) {
        collectionService.modify(collection.getId(), description, books);

        return "redirect:/collections";
    }

    // 컬렉션 삭제 버튼 클릭시
    @PostMapping("/collections/delete")
    public String delete(@RequestParam("id") Long id) {
        Collection collection = collectionService.findById(id);
        collectionService.delete(collection);

        return "redirect:/collections";
    }
}

