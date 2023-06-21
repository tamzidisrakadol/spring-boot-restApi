package com.example.springbootrestapi.service;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public Book addBook(Book b){
        booklist.add(b);
        return b;
    }

    public void deleteBook(int id){
      booklist=booklist.stream().filter(book->{
            if(book.getId()!=id){
                return true;
            }else{
                return false;
            }
        }).collect(Collectors.toList());

        //same logic with shorter code
        // booklist=booklist.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
    }

    public void updateBook(Book book,int id){
        booklist = booklist.stream().map(b->{

            if(b.getId()==id){
                b.setId(id);
                b.setBookName(book.getBookName());
                b.setBookAuthor(book.getBookAuthor());
            }
            
            return b;
        }).collect(Collectors.toList());
    }
    
}
