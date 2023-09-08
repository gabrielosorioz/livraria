package com.gabriel.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.livraria.entity.Book;
import com.gabriel.livraria.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bRepo;

    public void save(Book book) {
        bRepo.save(book);
    }

    public List<Book> getAllBook(){
        return bRepo.findAll();
    }

    public Book getBookById(int id){
        return bRepo.findById(id).get();
    }

    public void deleteById(int id) {
        bRepo.deleteById(id);
    }

}
