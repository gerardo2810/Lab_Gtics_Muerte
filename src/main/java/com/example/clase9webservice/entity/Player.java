package com.example.clase9webservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playerId")
    private int playerId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "mmr")
    private Long mmr;

    @Column(name = "position")
    private Integer position;

    @Column(name = "region", length = 100)
    private String region;

    // Constructors
    public Player() {}

    public Player(String name, Long mmr, Integer position, String region) {
        this.name = name;
        this.mmr = mmr;
        this.position = position;
        this.region = region;
    }

    // Getters and Setters
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMmr() {
        return mmr;
    }

    public void setMmr(Long mmr) {
        this.mmr = mmr;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                ", mmr=" + mmr +
                ", position=" + position +
                ", region='" + region + '\'' +
                '}';
    }
}
