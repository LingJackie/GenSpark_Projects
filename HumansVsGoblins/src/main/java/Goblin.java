public class Goblin extends Actor{
    public Goblin(String name, int strength, int constitution, int dexterity) {
        super(name, strength, constitution, dexterity);
        icon = ANSI_PURPLE+HORN_EMOJI+ANSI_RESET;
    }
}
