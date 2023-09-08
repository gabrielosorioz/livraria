package com.gabriel.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gabriel.livraria.entity.Book;
import com.gabriel.livraria.entity.MyBookList;
import com.gabriel.livraria.service.BookService;
import com.gabriel.livraria.service.MyBookListService;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private MyBookListService myBookService;

    
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook(){
        List<Book>listOfTheBooks = bookService.getAllBook();
        //ModelAndView m=new ModelAndView();
        //m.setViewName("bookList");
        //m.addObject("book",list);    
        return new ModelAndView("bookList","book",listOfTheBooks);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/available_books";
    }

    @GetMapping ("/my_books")
    public String getMyBooks(Model model){
        List<MyBookList>myListOfBooks = myBookService.getAllMyBooks();
        model.addAttribute("book",myListOfBooks);
        return "myBooks";
    }
    
    @RequestMapping("/mylist/{id}")
    public String getMyList (@PathVariable("id") int id){
        Book b = bookService.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }





    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteById(id);
        return "redirect:/available_books";

    }
    
    @RequestMapping ("/editBook/{id}")
    public String editBook(@PathVariable ("id")int id, Model model){
        Book b = bookService.getBookById(id);
        model.addAttribute("book", b);
        return "bookEdit";

    }



}
