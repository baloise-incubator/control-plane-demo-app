package com.baloise.platformplanedemoapp;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafIndexController {

  @GetMapping("/")
  public String index(final Model model) {
    SecurityContext context = SecurityContextHolder.getContext();
    if(context.getAuthentication().getPrincipal() instanceof DefaultOidcUser user) {
      String userName = user.getName();
      model.addAttribute("currentUser", userName);
    } else {
      model.addAttribute("currentUser", "Anonymous");
    }
    return "index";
  }
}
