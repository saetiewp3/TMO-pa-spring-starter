package com.galvanize.tmo.paspringstarter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    List<Book> listOfBooks = new ArrayList();

    public void addBook(Book book) {
        int newId = listOfBooks.size() + 1;
        book.setId(newId);
        listOfBooks.add(book);
    }

    public List<Book> sortListOfBooks() {
        List<Book> sortedBooks = listOfBooks.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
        return sortedBooks;
    }

    public void deleteBooks() {
        listOfBooks = new ArrayList();
    }

}
