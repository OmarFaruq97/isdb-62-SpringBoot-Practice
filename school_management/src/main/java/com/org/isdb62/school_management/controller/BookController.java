package com.org.isdb62.school_management.controller;

import org.springframework.web.bind.annotation.*;

import com.org.isdb62.school_management.dto.BookDTO;
import com.org.isdb62.school_management.model.Book;
import com.org.isdb62.school_management.service.BookService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController( BookService bookService){
        this.bookService=bookService;
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody BookDTO bookDTO) {
        Book saved = bookService.saveBook(bookDTO);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity <List<Book>> getAllBook() {
        List<Book> books =bookService.getAllBook();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <?> deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity <Book> updateBook(@PathVariable Integer id, @RequestBody Book Book) {
        Book updated = bookService.updateBook(id, Book);
        return new ResponseEntity<>( updated, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Book> getBook(@RequestParam Integer id) {
        Book book= bookService.getBook(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}