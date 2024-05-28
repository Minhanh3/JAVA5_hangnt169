package com.example.Assiment_java5.session03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserDAO userDAO = new UserDAO();

    @GetMapping("register")
    public String addOrEdit(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("action", "saveOrUpdate");
        return "register-user";
    }

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(Model model, User user) {
        userDAO.save(user);
        System.out.printf("Size: " + userDAO.getAll().size());

        return "register-user";
    }

    @GetMapping("list")
    public String list(Model model) {
        model.addAttribute("users", userDAO.getAll());
        return "view-user";
    }

    @GetMapping("/edit/{username}")
    public String edit(@PathVariable String username, Model model) {
        User user = userDAO.findByUserName(username);
        model.addAttribute("user", user);
        model.addAttribute("action", "/saveOrUpdate");
        return "register-user";
    }

    @GetMapping("/delete/{username}")
    public String delete(@PathVariable String username, Model model) {
        userDAO.delete(username);
        model.addAttribute("users", userDAO.getAll());
        return "view-user";
    }
}
