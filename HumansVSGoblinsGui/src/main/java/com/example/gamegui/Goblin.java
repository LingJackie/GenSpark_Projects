package com.example.gamegui;

public class Goblin extends Actor{
    protected final String HORN_EMOJI = "\uD83D\uDE08";
    public Goblin(String name, int strength, int constitution, int dexterity) {
        super(name, strength, constitution, dexterity);

        playable = false;
    }
    public Goblin() {
        super("goblin", 3, 3, 3);

        playable = false;
    }
}
