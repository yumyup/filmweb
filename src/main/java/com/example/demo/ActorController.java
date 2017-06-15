package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private CommentRepository ratingRepository;

    @RequestMapping("/actors")
    public String allActors(Model model) {
        List<Actor> all = actorRepository.findAll();
        model.addAttribute("allActors", all);
        model.addAttribute("actor", new Actor());
        return "actors";
    }

    @PostMapping("/actors/add")
    public String addActor(Actor actor) {
        actorRepository.save(actor);
        return "redirect:/actors";
    }

    @GetMapping("/actor")
    public String showActor(@RequestParam("id") Long id, Model model) {
        Actor actor = actorRepository.findOne(id);
        model.addAttribute("pojedyncczyAktor", actor);


        List<Comment> comments = actor.getComments();
        double srednia = 0;
        double iloscKomentarzy = 0;
        int sumKomentarzy = 0;
        for (Comment comment1 : comments) {     //petla przechodzaca po komentarzach i liczaca srednia ocen
            sumKomentarzy += comment1.getRating();
            iloscKomentarzy++;
        }
        srednia = sumKomentarzy / iloscKomentarzy;

        model.addAttribute("sredniaKomentarzy", srednia);
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", comments);
        List<Film> films = actor.getFilms();
        model.addAttribute("films",films);


        return "actor";
    }

    @RequestMapping("/actors/comment")
    public String addComment(Comment rating, @RequestParam Long aktorId) {
        Actor actor = actorRepository.findOne(aktorId);
        rating.setActor(actor);

        ratingRepository.save(rating);

        return "redirect:/actors";
    }

}
