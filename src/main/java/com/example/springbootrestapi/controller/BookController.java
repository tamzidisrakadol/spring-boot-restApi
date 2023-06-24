package com.example.springbootrestapi.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Book>> getBookinfo(){
        List<Book> bookList= bookService.getAllBook();
        if (bookList.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
        }

        return ResponseEntity.of(Optional.of(bookList));
    }

    //to get only single book
    @GetMapping("/bookId/{id}")
    public ResponseEntity<Book> getbookByid(@PathVariable("id")int id){
        Book book = bookService.getBookbyId(id);
        if (book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }


    //to create object 
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book books = null;
        try {
            books = this.bookService.addBook(book);
            System.out.println(books);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //to delete object
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void>  deleteBook(@PathVariable("id") int id){
        try{
            this.bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //to update an object
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("id") int id){
        try {
            this.bookService.updateBook(book, id);
            return ResponseEntity.ok().body(book);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
