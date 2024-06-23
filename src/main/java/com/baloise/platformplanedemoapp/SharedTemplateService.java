package com.baloise.platformplanedemoapp;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class SharedTemplateService {

    private final BuildProperties buildProperties;
    private final GitProperties gitProperties;

    public void addSharedProperties(Model model) {
        model.addAttribute("build", buildProperties);
        model.addAttribute("git", gitProperties);
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
    }
}
