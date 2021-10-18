package com.fullstack.springbootbackend.repository;

import com.fullstack.springbootbackend.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByPlayerName(String name);
}
