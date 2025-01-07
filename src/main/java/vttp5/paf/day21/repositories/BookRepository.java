package vttp5.paf.day21.repositories;

import java.lang.classfile.ClassFile.Option;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp5.paf.day21.model.Book;
import vttp5.paf.day21.util.Queries;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate template;
    
    public List<Book> getBooks(String author, int limit)
    {
        String formattedAuthor = "%" + author + "%";
        
        SqlRowSet rs = template.queryForRowSet(Queries.SQL_KINDLE_AUTHOR_LIMIT, formattedAuthor, limit);

        List<Book> bookList = new LinkedList<>(); // allows expansion?

        while (rs.next()) // while true, calling it the first time to move the cursor down once to read the record
        {
            bookList.add(Book.toBook(rs));
        }

        return bookList;
    }

    public Optional<Book> getBookByAsin(String asin)
    {
        SqlRowSet rs = template.queryForRowSet(Queries.SQL_KINDLE_ASIN, asin);

        // If reading the next line has nothing, return empty optional to prevent nullpointexcpetion
        if(!rs.next())
        {
            return Optional.empty();
        }

        Book b = Book.toBook(rs);

        return Optional.of(b);
    }

    // can check and extract with smth like 
    // Optional<Book> optionalBook = bookRepo.getBookByAsin("B0012345");
    // if (optionalBook.isPresent()) 
    // {
    //      Book book = optionalBook.get();
    //      System.out.println("Title: " + book.getTitle());
    // } 
    // else 
    // {
    //      System.out.println("Book not found!");
    // }

}
