package com.baloise.platformplanedemoapp.todo;

import com.baloise.platformplanedemoapp.SharedTemplateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
@RequiredArgsConstructor
public class ThymeleafTodoController {

  private final TodoRepository todoRepository;
  private final SharedTemplateService sharedTemplateService;

  @GetMapping("/todos")
  public String todos(final Model model) {
    sharedTemplateService.addSharedProperties(model);
    model.addAttribute("todos", todoRepository.findAll());
    model.addAttribute("todo", new Todo(null, null, false));
    return "todos";
  }

  @PostMapping("/addtodo")
  public String addTodo(@Valid Todo todo, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "todos";
    }
    todoRepository.save(todo);
    return "redirect:/todos";
  }
}
