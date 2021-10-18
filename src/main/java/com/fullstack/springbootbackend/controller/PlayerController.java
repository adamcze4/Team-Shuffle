package com.fullstack.springbootbackend.controller;

import com.fullstack.springbootbackend.entity.Player;
import com.fullstack.springbootbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping
    public ResponseEntity<String> addPlayer(@RequestBody Player player) {
        if (player.getPlayerName() != null && player.getEmail() != null) {
            playerRepository.save(player);
            return new ResponseEntity<>("Player has been created", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Invalid player attributes", HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<Player> getPlayerByName(@RequestParam String playername) {
        if (playername.isBlank()) {
            return new ResponseEntity("Invalid player name", HttpStatus.BAD_REQUEST);
        }
        Optional<Player> player = Optional.ofNullable(playerRepository.findByPlayerName(playername));

        return player.isPresent() ? new ResponseEntity<>(player.get(), HttpStatus.OK) :
                                    new ResponseEntity("Player not found", HttpStatus.NOT_FOUND);
    }
}
