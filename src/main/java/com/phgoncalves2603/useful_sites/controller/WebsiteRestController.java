package com.phgoncalves2603.useful_sites.controller;

import com.phgoncalves2603.useful_sites.entity.WebsiteEntity;
import com.phgoncalves2603.useful_sites.service.WebsiteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/websites")
public class WebsiteRestController {

    private final WebsiteService service;

    public WebsiteRestController(WebsiteService service) {
        this.service = service;
    }

    // GET all
    @GetMapping
    public List<WebsiteEntity> getAll() {
        return service.getAll();
    }

    // GET by ID
    @GetMapping("/{id}")
    public WebsiteEntity getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // POST create website
    @PostMapping
    public WebsiteEntity create(@RequestBody WebsiteEntity website) {
        return service.save(website);
    }

    // DELETE website
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // PUT update website (optional but good to have)
    @PutMapping("/{id}")
    public WebsiteEntity update(@PathVariable Long id,
                                @RequestBody WebsiteEntity website) {

        WebsiteEntity existing = service.getById(id);

        if (existing == null) {
            throw new RuntimeException("Website not found");
        }

        existing.setTitle(website.getTitle());
        existing.setUrl(website.getUrl());
        existing.setCategory(website.getCategory());
        existing.setDescription(website.getDescription());
        existing.setImage(website.getImage());

        return service.save(existing);
    }
}