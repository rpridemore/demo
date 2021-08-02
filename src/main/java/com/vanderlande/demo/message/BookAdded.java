package com.vanderlande.demo.message;

public class BookAdded {
    private String author;
    private String title;

    public BookAdded() {}

    public BookAdded(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "BookAdded{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
