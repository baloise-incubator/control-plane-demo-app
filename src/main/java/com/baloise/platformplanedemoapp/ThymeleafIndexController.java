package com.baloise.platformplanedemoapp;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
@RequiredArgsConstructor
public class ThymeleafIndexController {

 private final SharedTemplateService sharedTemplateService;

  @GetMapping("/")
  public String index(final Model model) {
    sharedTemplateService.addSharedProperties(model);
    return "index";
  }
}
