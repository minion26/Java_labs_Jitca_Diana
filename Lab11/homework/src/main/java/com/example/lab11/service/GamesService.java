package com.example.lab11.service;

import com.example.lab11.models.GamesEntity;
import com.example.lab11.repository.GamesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesService {

    private GamesRepo gamesRepo;

    public GamesService(GamesRepo gamesRepo) {
        this.gamesRepo = gamesRepo;
    }


    public List<GamesEntity> findAll() {
        return gamesRepo.findAll();
    }
}
