package com.example.btvn_b2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/ket-qua")
    public String ketQua(@RequestParam String uname, @RequestParam String psw, Model model) {
        if (uname.isEmpty()) {
            model.addAttribute("unameError" , "Username khong được trông");
//            return "redirect:/login";
            return "login";
        }
        if (psw.isEmpty()) {
            model.addAttribute("pswError" , "Password khong được trông");
//            return "redirect:/login";
            return "login";
        }
        return "home";
    }
}
