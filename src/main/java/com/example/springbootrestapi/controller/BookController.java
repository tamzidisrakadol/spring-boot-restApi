package com.example.springbootrestapi.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrestapi.modal.Book;
import com.example.springbootrestapi.service.BookService;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public String getBook(){
        return "this is a testingbook";
    }

    @GetMapping("/getBook")
    public List<Book> getBookinfo(){
        return this.bookService.getAllBook();
    }

    @GetMapping("/bookId/{id}")
    public Book getbookByid(@PathVariable("id")int id){
        return bookService.getBookbyId(id);
    }

}
