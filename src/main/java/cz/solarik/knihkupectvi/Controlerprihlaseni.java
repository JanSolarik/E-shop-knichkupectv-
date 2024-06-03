package cz.solarik.knihkupectvi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Controlerprihlaseni {
    public Controlerprihlaseni(KnihaRepository kr) {
        this.knihaRepository = kr;
    }
    private KnihaRepository knihaRepository;

    @GetMapping("/prihlaseni")
    public String prihlaseni1() {
        return "prihlaseni";
    }
    @GetMapping("/domecek")
    public String domecek1(Model model) {
        List<Kniha> knihy = knihaRepository.findAll();
        model.addAttribute("allKnihy",knihy);
        return "domecek";
    }
    @PostMapping("/domecek")
    public String prihlaseni2(@RequestParam String authorName,@RequestParam String name) {
        var kniha = new Kniha(name,authorName);
        knihaRepository.save(kniha);
        return "domecek";
    }
}
