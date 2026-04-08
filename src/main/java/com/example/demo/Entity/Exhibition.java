package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "exhibitions")
public class Exhibition extends Event {

    public Exhibition() {
    }

    public Exhibition(String title, LocalDate date, Integer duration, String location) {
        super(title, date, duration, location);
    }
}
