package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class FilmRestController {

    @Autowired
    private FilmRepository filmRepository;

    @ResponseBody
    @GetMapping("")
    public List<Film> list() {
        List<Film> all = filmRepository.findAll();
        return all;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> one(@PathVariable Long id) {
        Film film = filmRepository.findOne(id);
        if (film != null) {
            return ResponseEntity.ok(film);
        }
        return ResponseEntity.notFound().build();
    }
}
