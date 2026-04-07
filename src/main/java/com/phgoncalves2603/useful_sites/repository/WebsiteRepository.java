package com.phgoncalves2603.useful_sites.repository;


import com.phgoncalves2603.useful_sites.entity.WebsiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebsiteRepository  extends JpaRepository<WebsiteEntity,Long> {
    List<WebsiteEntity> findByCategory(String category);
}
