package vttp5.paf.day21.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp5.paf.day21.service.BookService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class BookController 
{
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String showLandingPage()
    {
       return "index";

    }

    @PostMapping("/search")
    public String postQuery(Model model) {
        
        
        return entity;
    }
    
}
