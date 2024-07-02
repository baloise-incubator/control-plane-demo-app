package com.baloise.platformplanedemoapp.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todos")
public class TodoRestController {

  private final TodoRepository todoRepository;

  @GetMapping
  public Iterable<Todo> getTodos() {
    return todoRepository.findAll();
  }

  @GetMapping("/create")
  public Todo create() {
    return todoRepository.save(new Todo("New Todo", "Details", false));
  }

  @PostMapping
  public Todo create(@RequestBody Todo todo) {
    return todoRepository.save(todo);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    todoRepository.deleteById(id);
  }

  @GetMapping("/headers")
  public String getHeaders(@RequestHeader Map<String, String> headers) {
    headers.forEach((key, value) -> {
      System.out.printf("Header '%s' = %s%n", key, value);
    });
    return "success";
  }
}
