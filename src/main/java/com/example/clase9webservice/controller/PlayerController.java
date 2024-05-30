package com.example.clase9webservice.controller;
import com.example.clase9webservice.entity.Player;
import com.example.clase9webservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/{region}")
    public List<Player> getLeaderboard(@PathVariable String region) {
        return playerRepository.findByRegionOrderByPosition(region);
    }

    @PostMapping("/add")
    public void addPlayer(@RequestBody Player player) {
        playerRepository.save(player);
        recalculateLeaderboardPositions(player.getRegion());
    }

    @PutMapping("/updateMmr/{playerId}")
    public void updatePlayerMmr(@PathVariable int playerId, @RequestParam Long newMmr) {
        Player player = playerRepository.findById(playerId).orElse(null);
        if (player != null) {
            player.setMmr(newMmr);
            playerRepository.save(player);
            recalculateLeaderboardPositions(player.getRegion());
        }
    }

    @DeleteMapping("/delete/{playerId}")
    public void deletePlayer(@PathVariable int playerId) {
        Player player = playerRepository.findById(playerId).orElse(null);
        if (player != null) {
            String region = player.getRegion();
            playerRepository.delete(player);
            recalculateLeaderboardPositions(region);
        }
    }

    private void recalculateLeaderboardPositions(String region) {
        List<Player> players = playerRepository.findByRegionOrderByMmrDesc(region);
        for (int i = 0; i < players.size(); i++) {
            Player currentPlayer = players.get(i);
            currentPlayer.setPosition(i + 1);
            playerRepository.save(currentPlayer);
        }
    }
}
