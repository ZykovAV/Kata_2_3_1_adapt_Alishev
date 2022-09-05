package ru.zykov.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.zykov.spring.dao.UserDao;
import ru.zykov.spring.models.User;
import ru.zykov.spring.services.UserService;

import javax.validation.Valid;
import java.time.Period;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/users/users";
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userService.show(id));
//        return "users/show";
//    }
//
//    @GetMapping("/new")
//    public String newUser(Model model) {
//        model.addAttribute("user", new User());
//        return "users/new";
//    }
//
//    @PostMapping
//    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()){
//            return "/users/new";
//        }
//        userService.save(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) {
//        model.addAttribute("user", userService.show(id));
//        return "users/edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") int id) {
//        if (bindingResult.hasErrors()){
//            return "users/edit";
//        }
//        userService.update(id, user);
//        return "redirect:/users";
//    }
//
//    @DeleteMapping({"{id}"})
//    public String delete(@PathVariable("id") int id) {
//        userService.delete(id);
//        return "redirect:/users";
//    }



}
