package com.example.Entity;

import java.util.Date;


public class BookMaster {

    private String bookId;
    private String bookTitle;
    private String authorName;
    private String publisher;
    private Date publicationDay;
    private Date insertDay;
    private Date updateDay;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublicationDay() {
        return publicationDay;
    }

    public void setPublicationDay(Date publicationDay) {
        this.publicationDay = publicationDay;
    }

    public Date getInsertDay() {
        return insertDay;
    }

    public void setInsertDay(Date insertDay) {
        this.insertDay = insertDay;
    }

    public Date getUpdateDay() {
        return updateDay;
    }

    public void setUpdateDay(Date updateDay) {
        this.updateDay = updateDay;
    }
}
