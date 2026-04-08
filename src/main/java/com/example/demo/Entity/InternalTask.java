package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "internal_tasks")
public class InternalTask extends Task {
    public InternalTask() {
    }

    public InternalTask(String title, LocalDate dueDate, boolean completed) {
        super(title, dueDate, completed);
    }
}
