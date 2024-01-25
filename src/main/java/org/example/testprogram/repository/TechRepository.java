package org.example.testprogram.repository;

import org.example.testprogram.entity.Tech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechRepository extends JpaRepository<Tech, Integer> {
}
