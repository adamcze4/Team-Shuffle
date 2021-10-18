package com.fullstack.springbootbackend.controller;

import com.fullstack.springbootbackend.entity.Team;
import com.fullstack.springbootbackend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @PostMapping
    public ResponseEntity<String> createTeam(@RequestBody Team team) {
        if (team != null && !team.getTeamName().isBlank()) {
            teamRepository.save(team);
            return new ResponseEntity<>("Team has been created", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Invalid team parameters", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all")
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
