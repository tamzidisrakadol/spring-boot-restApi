package com.example.springbootrestapi.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    //to get all list of book
    @GetMapping("/getBook")
    public List<Book> getBookinfo(){
        return this.bookService.getAllBook();
    }

    //to get only single book
    @GetMapping("/bookId/{id}")
    public Book getbookByid(@PathVariable("id")int id){
        return bookService.getBookbyId(id);
    }


    //to create object 
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        Book books = this.bookService.addBook(book);
        return books;
    }


    //to delete object
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id){
        this.bookService.deleteBook(id);
    }


    //to update an object
    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book,@PathVariable("id") int id){
        this.bookService.updateBook(book, id);
        return book;
    }

}
