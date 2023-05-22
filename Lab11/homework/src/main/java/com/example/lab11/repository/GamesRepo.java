package com.example.lab11.repository;

import com.example.lab11.models.GamesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesRepo extends JpaRepository<GamesEntity, Long>{
}
