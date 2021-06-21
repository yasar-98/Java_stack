package com.yasar.show.repoitories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yasar.show.models.Book;

@Repository
public interface BookRepositry extends CrudRepository<Book, Long>{
    List<Book> findAll();
    void deleteById(long ID);
    // this method finds books with descriptions containing the search string
//    List<Book> findByDescriptionContaining(String search);
//    // this method counts how many titles contain a certain string
//    Long countByTitleContaining(String search);
//    // this method deletes a book that starts with a specific title
//    Long deleteByTitleStartingWith(String search);

}
