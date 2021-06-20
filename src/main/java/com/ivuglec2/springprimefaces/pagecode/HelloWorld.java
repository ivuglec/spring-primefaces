package com.ivuglec2.springprimefaces.pagecode;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@ManagedBean
@ViewScoped
public class HelloWorld {

    @PostConstruct
    public void init() {
        System.out.println("HelloWorld --> init()");
    }

    public void logout() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.jsf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String showGreeting() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        return "Hello " + authentication.getName() + "!";
    }
}
