package com.example.spring_with_jsp;

import java.time.LocalDateTime;

public class Event {
    private String name;
    private LocalDateTime starts;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStarts() {
        return this.starts;
    }

    public void setStarts(LocalDateTime starts) {
        this.starts = starts;
    }
    

}
