package org.jin.projectCafe.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // main page
    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/mainDetail")
    public String mainDetailPage() {
        return "mainDetail";
    }
}
