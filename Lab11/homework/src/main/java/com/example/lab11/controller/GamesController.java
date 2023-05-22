package com.example.lab11.controller;

import com.example.lab11.models.GamesEntity;
import com.example.lab11.service.GamesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GamesController {

    private GamesService gamesService;

    public GamesController(GamesService gamesService) {
        this.gamesService = gamesService;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<GamesEntity> getAll(){
        return gamesService.findAll();
    }

}
