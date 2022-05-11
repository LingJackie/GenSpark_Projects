package com.example.gamegui;

public class Human extends Actor{
    private final String COWBOY_EMOJI = "\uD83E\uDD20";
    public Human(String name, int strength, int constitution, int dexterity, boolean playable) {
        super(name, strength, constitution, dexterity);

        this.playable = playable;
    }
}
