public class Goblin extends Actor{
    protected final String HORN_EMOJI = "\uD83D\uDE08";
    public Goblin(String name, int strength, int constitution, int dexterity) {
        super(name, strength, constitution, dexterity);
        icon = ColorAndEmoji.ANSI_PURPLE+HORN_EMOJI+ ColorAndEmoji.ANSI_RESET;
        playable = false;
    }
    public Goblin() {
        super("goblin", 3, 3, 3);
        icon = ColorAndEmoji.ANSI_PURPLE+HORN_EMOJI+ ColorAndEmoji.ANSI_RESET;
        playable = false;
    }
}
