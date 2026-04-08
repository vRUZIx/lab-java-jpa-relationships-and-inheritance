package com.example.demo.repository;

import com.example.demo.Entity.Division;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division, Long> {
    List<Division> findByDistrict(String district);
}
