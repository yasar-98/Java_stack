package com.yasar.update.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yasar.update.models.Book;
import com.yasar.update.repoitories.BookRepositry;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepositry bookRepository;
    
    public BookService(BookRepositry bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        }
            return null;
        
    }
    public Book updateBook(Long id,String title,String desc,String lang,int numOfPages) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
          Book y= optionalBook.get();
                  y.setTitle(title);
                  y.setDescription(desc);
                  y.setLanguage(lang);
                  y.setNumberOfPages(numOfPages);
                return  bookRepository.save(y);

        } else {
            return null;
        }}
        public void deleteBook(Long id) {
            Optional<Book> optionalBook = bookRepository.findById(id);
            Book y =optionalBook.get();
            bookRepository.delete(y);
        }
    }
    

