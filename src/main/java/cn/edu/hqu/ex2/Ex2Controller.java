package cn.edu.hqu.ex2;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.validation.BindingResult;

import cn.edu.hqu.ex2.model.Course;
import cn.edu.hqu.ex2.model.Student;

@Controller
public class Ex2Controller {

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/stuinfo")
    public String stuinfo(Model model) {
        model.addAttribute("student", new Student());
        return "stuinfo";
    }

    @PostMapping("/courseselect")
    public String courseselect(@Valid @ModelAttribute Student student,
                            BindingResult bindingResult, 
                            Model model) {
        if (bindingResult.hasErrors()) {
            return "stuinfo";
        }
        model.addAttribute("courses", getCourses());
        model.addAttribute("student", student);
        return "courseselect";
    }

    @PostMapping("/result")
    public String result(@ModelAttribute Student student,
            @RequestParam(name = "selectedCourses") List<String> selectedCourses,
            Model model) {
        model.addAttribute("student", student);
        model.addAttribute("selectedCourses", selectedCourses);
        return "result";
    }

    private List<Course> getCourses() {
        return Arrays.asList(
                new Course("计算机导论"),
                new Course("高等数学"),
                new Course("大学物理"),
                new Course("操作系统"),
                new Course("计算机网络"));
    }
}
