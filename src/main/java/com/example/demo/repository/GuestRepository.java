package com.example.demo.repository;

import com.example.demo.Entity.Guest;
import com.example.demo.Entity.GuestStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByStatus(GuestStatus status);
}
