package com.gabriel.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gabriel.livraria.service.MyBookListService;

@Controller
public class MyBookController {
    
    @Autowired
    private MyBookListService myBookService;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyListBook(@PathVariable ("id") int id){
        myBookService.deleteById(id);
        return "redirect:/my_books";
    }

    

}
