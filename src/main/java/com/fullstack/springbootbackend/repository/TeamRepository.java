package com.fullstack.springbootbackend.repository;

import com.fullstack.springbootbackend.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
