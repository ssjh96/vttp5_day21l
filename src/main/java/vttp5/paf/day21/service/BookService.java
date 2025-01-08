package vttp5.paf.day21.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp5.paf.day21.model.Book;
import vttp5.paf.day21.repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    public List<Book> getBooksByAuthor(String author, int count)
    {
        return bookRepo.getBooks(author, count);
    }



    public Optional<Book> getBooksByAsin(String asin)
    {
        Optional<Book> optionalBook = bookRepo.getBookByAsin(asin);

        return optionalBook;
        // if (optionalBook.isPresent())
        // {
        //     Book book = optionalBook.get();
        //     return book;
        // }

        // throw new RuntimeException("Book not found for ASIN: " + asin);
    }
}
