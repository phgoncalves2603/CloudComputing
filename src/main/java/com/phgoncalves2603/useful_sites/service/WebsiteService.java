package com.phgoncalves2603.useful_sites.service;


import com.phgoncalves2603.useful_sites.entity.WebsiteEntity;
import com.phgoncalves2603.useful_sites.repository.WebsiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebsiteService {
    private final WebsiteRepository repository;

    public WebsiteService(WebsiteRepository repository){
        this.repository = repository;
    }
    public List<WebsiteEntity> getAll() {
        return repository.findAll();
    }

    public WebsiteEntity save(WebsiteEntity website) {
        return repository.save(website);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public WebsiteEntity getById(Long id) {
        return repository.findById(id).orElse(null);
    }

}
