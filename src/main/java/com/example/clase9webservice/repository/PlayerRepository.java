package com.example.clase9webservice.repository;


import com.example.clase9webservice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByRegionOrderByPosition(String region);

    List<Player> findByRegionOrderByMmrDesc(String region);
}
