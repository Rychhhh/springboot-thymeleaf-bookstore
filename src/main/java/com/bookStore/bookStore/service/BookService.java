package com.bookStore.bookStore.service;


import com.bookStore.bookStore.domain.Book;
import com.bookStore.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class BookService {


    @Autowired
    private BookRepository bRepo;


    public void saveBook(Book b) {
        System.out.println("data" + b);
        bRepo.save(b);
    }
}
