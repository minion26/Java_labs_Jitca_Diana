package com.example.lab11.repository;

import com.example.lab11.models.PlayersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersRepo extends JpaRepository<PlayersEntity, Long> {


    @Query(value = "SELECT * FROM players WHERE name = :name", nativeQuery = true)
    PlayersEntity findByName(@Param("name") String name);
}
