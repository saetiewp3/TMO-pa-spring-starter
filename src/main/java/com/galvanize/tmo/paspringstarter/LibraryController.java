package com.galvanize.tmo.paspringstarter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    Service service = new Service();

    @GetMapping("/health")
    public void health() {
        System.out.println("App is running");

    }

    @PostMapping(value = "/api/books", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addBooks(@RequestBody String input) {

        Gson gson = new Gson();
        Book book = gson.fromJson(input, Book.class);

        service.addBook(book);

        String bookStr = gson.toJson(book, Book.class);
        return new ResponseEntity<>(bookStr, HttpStatus.CREATED);
    }

    @GetMapping("/api/books")
    public Books getBooks() {
        List<Book> l = service.sortListOfBooks();
        Books books = new Books();
        books.setBooks(l);
        return books;
    }

    @DeleteMapping("/api/books")
    public ResponseEntity<String> deleteBooks() {
        service.deleteBooks();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
