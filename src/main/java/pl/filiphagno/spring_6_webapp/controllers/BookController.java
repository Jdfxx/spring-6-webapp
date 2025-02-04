package pl.filiphagno.spring_6_webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.filiphagno.spring_6_webapp.services.BookService;

@Controller
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }
}
