package com.deloitte.todo.controller;

import java.security.Principal;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.deloitte.todo.model.TodoList;
import com.deloitte.todo.repository.TodoListRepository;

@Controller
public class TodoListController {

	@Autowired
	private TodoListRepository todoListRepository;
	
	@GetMapping("/welcome")
	public String getTodoList(Principal principal, Model model) {
		System.out.println(principal.getName());
		model.addAttribute("todoList", todoListRepository.findByUserId(principal.getName()));
		 return "/welcome";
	}
	
	@GetMapping("/addNewTodoItem")
	public String addTodo() {
	return "/add-todo-list";	
	}
	
	@PostMapping("/addTodoItem")
	public String addTodoItem(@ModelAttribute TodoList todoList, Model model, Principal principal) {
		todoList.setUserId(principal.getName());
		//todoList.setLastModifiedDate(new Date(0));
		todoListRepository.save(todoList);
		model.addAttribute("todoList", todoListRepository.findByUserId(principal.getName()));
		return "/welcome";
	}
}
