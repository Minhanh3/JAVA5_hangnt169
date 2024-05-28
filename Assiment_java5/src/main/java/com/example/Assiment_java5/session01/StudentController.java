package com.example.Assiment_java5.session01;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/student")
public class StudentController {

    @GetMapping("student/from")
    public String showfrom() {
        return "student-form";
    }

    @PostMapping("student/save")
    public String saveData(Model model, @RequestParam String name, @RequestParam String mark, @RequestParam String major) {
        model.addAttribute("NAME", "Ho va ten: " + name);
        model.addAttribute("MARK", "Diem tb: " + mark);
        model.addAttribute("MAJOR", "chuyen nganh: " + major);
        return "student-info";
    }

    @GetMapping("cal")
    public String showcal() {
        return "cal";
    }
    @PostMapping("ketqua")
    public String showketqua(Model model , @RequestParam int numa, @RequestParam int numb ) {
        int kq = numa + numb ;
        model.addAttribute("kq", kq);
        return "ketqua";
    }
}
