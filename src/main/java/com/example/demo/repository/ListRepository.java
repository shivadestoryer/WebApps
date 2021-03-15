package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ToDoList;


@Repository
public interface ListRepository extends CrudRepository<ToDoList, Integer> {
	public ToDoList getById(int id);
	public ToDoList getByisDeleted(boolean isDeleted);

}
