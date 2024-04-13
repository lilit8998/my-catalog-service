package com.example;

import com.example.config.BookShopProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final BookShopProperties bookShopProperties;

    public HomeController(BookShopProperties bookShopProperties) {
        this.bookShopProperties = bookShopProperties;
    }

    @GetMapping("/")
    public String getGreeting() {
        return bookShopProperties.getGreeting();
    }
}
