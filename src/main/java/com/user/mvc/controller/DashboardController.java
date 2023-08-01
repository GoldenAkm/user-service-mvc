package com.user.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping("/page") // TODO: FILL THE CONTROLLERS
    public String getDashboardPage() {
        return "dashboard/dashboard";
    }

}
