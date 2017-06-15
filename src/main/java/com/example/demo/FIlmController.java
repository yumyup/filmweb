package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FIlmController {
    @Autowired
    private FilmRepository filmRepository;

    @GetMapping("/films")      // po wejsciu na adres www zaczyna sie metoda
    public String all(Model model) {
        List<Film> allFilms = filmRepository.findAll();
        model.addAttribute("films", allFilms);
        return "films"; //szuka films.html
    }

    @GetMapping("/film/usun")
    public String usun(@RequestParam("id)") Long movieId) {
        filmRepository.delete(movieId);
        return "redirect:/films";   //redirect odswierzenie strony po usunieciu filmu
    }

    @GetMapping("/film")
    public String showOpis(@RequestParam("id") Long id, Model model) {
        Film film = filmRepository.findOne(id);
        model.addAttribute("film", film);
        return "film";
    }

}
