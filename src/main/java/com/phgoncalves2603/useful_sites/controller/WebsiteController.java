package com.phgoncalves2603.useful_sites.controller;


import com.phgoncalves2603.useful_sites.entity.WebsiteEntity;
import com.phgoncalves2603.useful_sites.service.WebsiteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebsiteController {
    private final WebsiteService service;

    public WebsiteController(WebsiteService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("websites", service.getAll());
        return "index";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("website", new WebsiteEntity());
        return "add-website";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute WebsiteEntity website) {
        service.save(website);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }

}
