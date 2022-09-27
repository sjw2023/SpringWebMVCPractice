package com.example.spring_with_jsp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EvnetController {

    @GetMapping("/events")
    public String getEvents(Model model){
        Event event1 = new Event();
        event1.setName("스프링 웹 MVC 스터디 1");
        event1.setStarts(LocalDateTime.of(2019, 1, 15, 10, 0));
        Event event2 = new Event();
        event2.setName("스프링 웹 MVC 스터디 1");
        event2.setStarts(LocalDateTime.of(2019, 1, 15, 12, 0));
        List< Event > events = List.of(event1, event2);

        model.addAttribute("events", events);
        model.addAttribute("message", "Happy New Year");
        return "events/list";
    }
    
}
