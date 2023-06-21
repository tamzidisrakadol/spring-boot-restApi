package com.example.springbootrestapi.service;

import java.util.ArrayList;
import java.util.List;

import com.example.springbootrestapi.modal.Book;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    private static List<Book> booklist = new ArrayList<>();

    static{
        booklist.add(new Book(125,"Java","oreli"));
        booklist.add(new Book(1254,"Head first kotlin","anuj"));
        booklist.add(new Book(4218,"Android authority","Cook"));
        booklist.add(new Book(785,"Android Cookbook","Android Cooper"));
    }


    public List<Book> getAllBook(){
        return booklist;
    }

    
    public Book getBookbyId(int id){

        Book book = null;
        book=booklist.stream().filter(e->
            e.getId()==id
        ).findFirst().get();
        
        return book;
    }
    
}
