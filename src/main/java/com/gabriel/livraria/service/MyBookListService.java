package com.gabriel.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.livraria.entity.MyBookList;
import com.gabriel.livraria.repository.MyBookRepository;

@Service
public class MyBookListService {

    @Autowired
    private MyBookRepository myBookRepository;

    public void saveMyBooks(MyBookList mybook ){
        myBookRepository.save(mybook);
    }

    public List<MyBookList> getAllMyBooks(){
        return myBookRepository.findAll();
    }

    public void deleteById (int id){
        myBookRepository.deleteById(id);

    }

    
}
