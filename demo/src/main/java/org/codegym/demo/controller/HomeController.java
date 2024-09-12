package org.codegym.demo.controller;
import org.codegym.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    private final UserService userService;
    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String homePage() {
        return "home";
    }

    @GetMapping(value = "/login")
    public String loginForm() {
        return "auth/login";
    }

    @PostMapping(value = "/login")
    public String loginResult(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if (userService.loginStatus(username, password)) return "redirect: /home";
        model.addAttribute("message", "Wrong username or password");
        return "auth/login";
    }
}
