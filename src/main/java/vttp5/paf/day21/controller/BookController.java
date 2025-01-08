package vttp5.paf.day21.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import vttp5.paf.day21.model.Book;
import vttp5.paf.day21.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class BookController 
{
    @Autowired
    private BookService bookService;

    // Springboot automatically returns index.html when / request is made.
    // @GetMapping("/")
    // public String showLandingPage() 
    // {
    //     return "index";
    // }


    @GetMapping("/search")
    public String showResults(@RequestParam ("author") String author, @RequestParam ("limit") Integer limit, Model model) 
    {
        List<Book> bookList =  bookService.getBooksByAuthor(author, limit);

        model.addAttribute("bookList", bookList);

        // only got postmapping for search cannot use redirect as in tries to do a get request when redirect, throwing 405 not allowed
        return "search";
    }

    @GetMapping("/details")
    public String getBookDetails(@RequestParam ("asin") String asin, @RequestParam ("author") String author, @RequestParam("limit") Integer limit, Model model) 
    {
        Optional<Book> optBook = bookService.getBooksByAsin(asin);

        if (optBook.isPresent())
        {
            Book b = optBook.get();

            model.addAttribute("book", b);
            model.addAttribute("author", author);
            model.addAttribute("limit", limit);

            return "details";
        }

        throw new RuntimeException("Book not found!");
    }
    
    

    // @PostMapping("/search")
    // public String postQuery(Model model) {
        
        
    //     return entity;
    // }
    
}
