package coltla.com.spring6webapp.controllers;

import org.springframework.stereotype.Controller;

import coltla.com.spring6webapp.services.BookService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @RequestMapping("/books")
  public String getBooks(Model model) {
    model.addAttribute("books", bookService.findAll());

    return "books";
  }
}
