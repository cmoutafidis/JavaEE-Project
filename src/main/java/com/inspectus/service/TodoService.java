/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inspectus.service;

import com.inspectus.entity.Todo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author c.moutafidis
 */
@Transactional
public class TodoService {
    
    @PersistenceContext
    EntityManager entityManager;
    
    public Todo createTodo(Todo todo){
        this.entityManager.persist(todo);
        return todo;
    }
    
    public Todo updateTodo(Todo todo){
        this.entityManager.merge(todo);
        return todo;
    }
    
    public Todo findTodoById(long id){
        return this.entityManager.find(Todo.class, id);
    }
    
    public List<Todo> getTodos(){
        return this.entityManager.createNativeQuery("SELECT id, task, isCompleted, dateCreated, dueDate, dateCompleted FROM todo", Todo.class).getResultList();
    }
    
}
