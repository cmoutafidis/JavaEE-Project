/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inspectus.rest;

import com.inspectus.entity.Todo;
import com.inspectus.service.TodoService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author c.moutafidis
 */
@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest {
    
    @Inject
    TodoService todoService;
    
    @Path("new")
    @POST
    public Response createTodo(Todo todo){
        this.todoService.createTodo(todo);
        
        return Response.ok(todo).build();
    }
    
    
    @Path("update")
    @POST
    public Response updateTodo(Todo todo){
        this.todoService.updateTodo(todo);
        
        return Response.ok(todo).build();
    }
    
    @Path("{id}")
    @GET
    public Todo getTodo(@PathParam("id")long id){
        return this.todoService.findTodoById(id);
    }
    
    @Path("list")
    @GET
    public List<Todo> getTodos(){
        return this.todoService.getTodos();
    }
    
}
