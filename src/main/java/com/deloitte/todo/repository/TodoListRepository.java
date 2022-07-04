package com.deloitte.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.todo.model.TodoList;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, String>{

	List<TodoList> findByUserId(String string);

}
