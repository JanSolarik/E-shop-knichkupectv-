package cz.solarik.knihkupectvi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class Controlerprihlaseni {

    public Controlerprihlaseni(KnihaRepository kr) {
        this.knihaRepository = kr;
    }
    private KnihaRepository knihaRepository;
    @Autowired
    private KnihaService knihaService;
    @GetMapping("/prihlaseni")
    public String prihlaseni1() {
        return "prihlaseni";
    }
    @GetMapping("/domecek")
    public String domecek1(Model model) {
        List<Kniha> listKnih = knihaRepository.findAll();
        model.addAttribute("allKnihy",listKnih);
        model.addAttribute("Uzivatel", SecurityContextHolder.getContext().getAuthentication().getName() );
        System.out.println(listKnih);

        return "domecek";
    }
    @PostMapping("/domecek")
    public String prihlaseni2(@RequestParam String authorName,@RequestParam String name) {
        var kniha = new Kniha(name,authorName);
        knihaRepository.save(kniha);
        return "redirect:/domecek";
    }
    @PostMapping("/deleteKniha")
    public String zmizikovani(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        knihaService.deleteKniha(id);
        redirectAttributes.addFlashAttribute("info","payment successful");
        return "redirect:/domecek";
    }
}
