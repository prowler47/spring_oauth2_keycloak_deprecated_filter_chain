package ua.dragunovskiy.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestController {

    @GetMapping("/")
    public HashMap<String, String> index() {
        OAuth2User user = ((OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        HashMap<String, String> userData = new HashMap<>();
        userData.put("hello", user.getAttribute("name"));
        userData.put("email is: ", user.getAttribute("email"));
        return userData;
    }
}
