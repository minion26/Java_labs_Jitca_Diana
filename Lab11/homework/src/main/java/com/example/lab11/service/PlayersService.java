package com.example.lab11.service;

import com.example.lab11.models.PlayersEntity;
import com.example.lab11.repository.PlayersRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersService {

    private PlayersRepo playersRepo;

    public PlayersService(PlayersRepo playerRepo) {
        this.playersRepo = playerRepo;
    }


    public List<PlayersEntity> findAll() {
        return playersRepo.findAll();
    }


    public PlayersEntity addPlayer(PlayersEntity player) {
        return playersRepo.save(player);
    }

    public PlayersEntity updatePlayer(PlayersEntity newPlayer, String name) {
        PlayersEntity player = playersRepo.findByName(name);
        //if the player exists
        if(player != null){
            if(newPlayer.getName() != null){
                player.setName(newPlayer.getName());
            }

            if(newPlayer.getAge() !=null){
                player.setAge(newPlayer.getAge());
            }

            if(newPlayer.getTeam() != null){
                player.setTeam(newPlayer.getTeam());
            }

            return playersRepo.save(player);
        }
        return null;
    }

    public void deletePlayer(String name) {
        PlayersEntity player = playersRepo.findByName(name);
        if(player != null){
            playersRepo.delete(player);
        }
    }
}
