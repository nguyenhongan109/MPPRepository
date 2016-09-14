package com.mpp.library.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String ISBN;
    private List<Author> authorList;
    private List<BookCopy> bookCopies;

    public Book(String title, String ISBN) {
        this.title = title;
        this.ISBN = ISBN;
        this.authorList = new ArrayList<>();
        this.bookCopies = new ArrayList<>();
    }

    public boolean addAuthor(Author author){
        return authorList.add(author);
    }

    public boolean addBookCopy(BookCopy bookCopy){
        return bookCopies.add(bookCopy);
    }

    public SimpleStringProperty titleProperty(){
        return new SimpleStringProperty(title);
    }

    public SimpleStringProperty ISBNProperty(){
        return new SimpleStringProperty(ISBN);
    }

    public SimpleStringProperty authorProperty(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Author author : authorList){
            stringBuilder.append(author.toString());
        }
        return new SimpleStringProperty(stringBuilder.toString());
    }

    public SimpleIntegerProperty availabilityProperty(){
        int availability = 0;
        for(BookCopy bookCopy : bookCopies){
            if(bookCopy.isAvailability()) availability += 1;
        }
        return new SimpleIntegerProperty(availability);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(List<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }
}
