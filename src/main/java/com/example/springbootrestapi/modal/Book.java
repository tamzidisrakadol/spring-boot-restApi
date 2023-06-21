package com.example.springbootrestapi.modal;

public class Book {

    private int id;
    private String bookName;
    private String bookAuthor;


    public Book(int id, String bookName, String bookAuthor) {
        this.id = id;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }


    public Book() {
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getBookName() {
        return bookName;
    }


    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public String getBookAuthor() {
        return bookAuthor;
    }


    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }


    @Override
    public String toString() {
        return "Book [id=" + id + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + "]";
    }

    
}
