package com.example.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.emp.domain.Student;
import com.example.emp.service.StudentService;



@Controller
@RequestMapping({ "/", "/index" })
public class ViewController {

	 @Autowired
	    private StudentService service;

	    @GetMapping
	    public String viewHomePage(Model model) {
	        List<Student> liststudent = service.listAll();
	        model.addAttribute("liststudent", liststudent);
	        System.out.print("Get / ");
	        return "index";
	    }

	    @GetMapping("/new")
	    public String add(Model model) {
	        model.addAttribute("student", new Student());
	        return "new";
	    }

}
