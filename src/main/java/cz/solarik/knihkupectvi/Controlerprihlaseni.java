package cz.solarik.knihkupectvi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controlerprihlaseni {

    @GetMapping("/prihlaseni")
    public String prihlaseni1() {
        return "prihlaseni";
    }
    @GetMapping("/registrace")
    public String registrace1() {
        return "registrace";
    }
    @GetMapping("/domecek")
    public String domecek1() {
        return "domecek";
    }
    @GetMapping("/book")
    public String book1() {
        return "book";
    }
    @PostMapping("/prihlaseni")
    public String registrace2() {
        return "prihlaseni";
    }
    @PostMapping("/domecek")
    public String prihlaseni2() {
        return "domecek";
    }
    @PostMapping("/book")
    public String book2() {
        return "book";
    }
}
