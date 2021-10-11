package com.fullstack.springbootbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "amount_of_players")
    private long amoutOfPlayers;

    @Column(name = "captain_name")
    private String captainName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public long getAmoutOfPlayers() {
        return amoutOfPlayers;
    }

    public void setAmoutOfPlayers(long amoutOfPlayers) {
        this.amoutOfPlayers = amoutOfPlayers;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }
}
