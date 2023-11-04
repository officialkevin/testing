package com.geekster.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Todocontroller {


@Autowired
    List<Todo>Todovar;

     @PostMapping("Todo")
 public String postTodo(@RequestBody Todo todo){
        Todovar.add(todo);
        return "todo added";

    }

    @GetMapping("Todoget")
    public List<Todo> Todova(){
         return Todovar;
    }


    @PutMapping("todo/put/{id}/{done}")
    public String postMapping(@PathVariable Integer id,@PathVariable boolean done){

         for(Todo todo :Todovar){
             if(todo.getId().equals(id)){
                 todo.setDone(done);
                 return "done";
             }
         }
         return "not done";


    }

@DeleteMapping("todo/delete/{id}")
    public String deleteMapping(@PathVariable Integer id){

        for(Todo todo :Todovar){
            if(todo.getId().equals(id)){
                Todovar.remove(todo);
                return "removed";
            }
        }
        return "not done";


    }



}
