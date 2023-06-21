package com.bookStore.bookStore.api;

import com.bookStore.bookStore.domain.Book;
import com.bookStore.bookStore.domain.MyBookList;
import com.bookStore.bookStore.repository.BookRepository;
import com.bookStore.bookStore.service.BookService;
import com.bookStore.bookStore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bService;

    @Autowired
    private MyBookService myBookService;
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
    public ModelAndView availableBook()
    {
        List<Book> list = bService.getAllBook();
        return new ModelAndView("availableBooks", "book",   list);
    }


//    @GetMapping("my-books")
//    public ModelAndView myBooks()
//    {
//        List<MyBookList> list = myBookService.getAllMyBook();
//        return new ModelAndView("myBooks", "book", list);
//    }
    @GetMapping("my-books")
    public String myBooks()
    {
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        // cari dari service book id nya
        Book bookId = bService.getById(id);

        // lalu definisi kan ke domain nya mybook
        MyBookList  bookList = new MyBookList(bookId.getId(), bookId.getName(), bookId.getAuthor(), bookId.getPrice());
        System.out.println(bookList);
//        myBookService.saveMyBook(bookList);
        return "redirect:/my-books";
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book)
    {
        System.out.println("data dicontroller" + book.toString());
        bService.saveBook(book);
        return "redirect:/available-book";
    }
}
