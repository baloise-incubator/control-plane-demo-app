package com.baloise.platformplanedemoapp;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class ThymeleafIndexController {

  @GetMapping("/")
  public String index(final Model model) {
    SecurityContext context = SecurityContextHolder.getContext();
    if(context.getAuthentication().getPrincipal() instanceof DefaultOidcUser user) {
      String userName = user.getName();
      String mail = user.getPreferredUsername();
      model.addAttribute("currentUser", userName + " (" + mail + ")");
      Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
      model.addAttribute("role", authorities.iterator().next());
      model.addAttribute("issuer", "Azure EntraID");
      model.addAttribute("mail", mail);
      model.addAttribute("name", userName);
    } else {
      model.addAttribute("currentUser", "Anonymous");
    }
    return "index";
  }
}
