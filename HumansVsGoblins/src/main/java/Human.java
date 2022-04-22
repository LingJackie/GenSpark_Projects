public class Human extends Actor{

    public Human(String name, int strength, int constitution, int dexterity) {
        super(name, strength, constitution, dexterity);
        icon = ANSI_YELLOW+COWBOY_EMOJI+ANSI_RESET;
    }
}
