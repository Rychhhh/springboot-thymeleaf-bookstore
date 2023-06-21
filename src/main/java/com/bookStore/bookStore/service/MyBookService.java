package com.bookStore.bookStore.service;

import com.bookStore.bookStore.domain.MyBookList;
import com.bookStore.bookStore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {

    @Autowired
    private MyBookRepository repository;


    public List<MyBookList> getAllMyBook()
    {
        return repository.findAll();
    }

    public void saveMyBook(MyBookList book)
    {
        repository.save(book);
    }
}
