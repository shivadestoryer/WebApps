package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ToDoList;
import com.example.demo.repository.ListRepository;

@Service
public class ListService {
	private ListRepository repository;

    @Autowired
    public ListService(ListRepository repository) {
        this.repository = repository;
    }

    public List<ToDoList> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<ToDoList> findById(int id) {
        return repository.findById(id);
    }
    
    public ToDoList getByisDeleted(boolean isDeleted) {
        return repository.getByisDeleted(isDeleted);
    }


    public ToDoList save(ToDoList stock) {
        return repository.save(stock);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
    
    public ToDoList getById(int id) {
    	return repository.getById(id);
    }

}
