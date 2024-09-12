package org.codegym.demo.controller;

import org.codegym.demo.entity.User;
import org.codegym.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "users")
public class UsersController {

    private final UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String usersPage(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "users/users";
    }

    @GetMapping(value = "/delete/{id}")
    public String userDelete(@PathVariable("id") int id){
        userService.deleteUser(userService.findById(id));
        return "redirect: /users";
    }

    @GetMapping(value = "/edit/{id}")
    public String userEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "users/edit";
    }

    @PostMapping("/edit")
    public String userEditing(@ModelAttribute User user, Model model) {
        String message = "Cập nhật thành công";
        try {
            userService.saveUser(user);
        } catch (RuntimeException e) {
            message = "Username đã tồn tại";
        }
        model.addAttribute("message", message);
        return "users/edit";
    }


    @GetMapping("/add")
    public String addForm() {
        return "users/add";
    }

    @PostMapping("/add")
    public String userAdd(@ModelAttribute User user, Model model) {
        String message = "Tạo tk thành công";
        try {
            userService.saveUser(user);
        } catch (RuntimeException e) {
            message = "Username đã tồn tại";
        }
        model.addAttribute("message", message);
        return "users/add";
    }
}
