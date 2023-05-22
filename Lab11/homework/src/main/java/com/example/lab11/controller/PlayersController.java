package com.example.lab11.controller;

import com.example.lab11.models.PlayersEntity;
import com.example.lab11.service.PlayersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayersController {

    private final PlayersService playerService;

    public PlayersController(PlayersService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<PlayersEntity> getAll(){
        return playerService.findAll();
    }

    @PostMapping(value = "/add", produces = "application/json")
    public PlayersEntity addPlayer(@RequestBody PlayersEntity player){
        return playerService.addPlayer(player);
    }

    @PutMapping(value = "/update/{name}", produces = "application/json")
    public PlayersEntity updatePlayer(@RequestBody PlayersEntity newPlayer, @PathVariable String name){
        return playerService.updatePlayer(newPlayer, name);
    }

    @DeleteMapping(value = "/delete/{name}", produces = "application/json")
    public void deletePlayer(@PathVariable String name){
        playerService.deletePlayer(name);
    }

}
