package com.vanderlande.demo.message;

public class BookAdditionConfirmed {
    private long id;

    public BookAdditionConfirmed() {}

    public BookAdditionConfirmed(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
