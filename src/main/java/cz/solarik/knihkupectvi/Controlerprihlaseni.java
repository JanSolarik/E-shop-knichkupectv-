package cz.solarik.knihkupectvi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controlerprihlaseni {
    @GetMapping("/prihlaseni")
    public String prihlaseni() {
        for (int i = 0; i < 10; ++i) {
            System.out.println("Hello World");
        }
        return "prihlaseni";
    }
    @PostMapping("/register")
    public String postregistrace() {
        System.out.println("registrace uspesna");
        return "prihlaseni";
    }
    @GetMapping("/register")
    public String getregister() {
        return "registrace";
    }
}
