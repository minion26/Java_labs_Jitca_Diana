package com.example.client.service;

import com.example.client.models.GamesEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {
    private List<GamesEntity> callTheService() {
        RestTemplate restTemplate = new RestTemplate();
        GamesEntity[] response = restTemplate.getForObject(
                "http://localhost:8081/games/all",
                GamesEntity[].class);

        List<GamesEntity> team = Arrays.stream(response).toList();
        return team;
    }


    public String get(Model model) {

        List<GamesEntity> team1 = this.callTheService();
        model.addAttribute("team1", team1);

        return "";
    }
}
