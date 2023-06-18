package com.bookStore.bookStore.api;

import com.bookStore.bookStore.domain.Book;
import com.bookStore.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService service;
    @GetMapping("/")
    public String home()
    {
        return "home";
    }


    @GetMapping("/book-registration")
    public String bookRegistration()
    {
        return "bookRegistration";
    }

    @GetMapping("available-book")
    public String availableBook()
    {
        return "availableBooks";
    }


    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b)
    {
        System.out.println("data dicontroller" + b.toString());
//        service.saveBook(b);
        return "redirect:/available-book";
    }
}
