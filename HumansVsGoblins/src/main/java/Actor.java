public class Actor {
    // Colors and emojis
    protected final String ANSI_YELLOW = "\u001B[33m";
    protected final String ANSI_GREEN = "\u001B[32m";
    protected final String ANSI_PURPLE = "\u001B[35m";
    protected final String ANSI_RESET = "\u001B[0m";

    protected final String COWBOY_EMOJI = "\uD83E\uDD20";
    protected final String HORN_EMOJI = "\uD83D\uDE08";


    private String name;
    private int strength;// Determines damage dealt
    private int constitution;// Determines health
    private int dexterity;// Determines initiative

    private int attackPower;// Derived from strength and weapon stats
    private int maxHealth;// Derived from constitution and maybe armor
    private int initiative;// Derived from dexterity

    private int currHealth;

    protected String icon;

    int locx;// x location on map
    int locy;// y location on map

    public String getHealth()   { return currHealth +"/"+ maxHealth; }
    public String getName()     { return name; }
    public int getX()           { return locx; }
    public int getY()           { return locy; }

    public void setLocation(int x, int y) { locx=x; locy=y; }

    public boolean isDead(){
        return currHealth <= 0;
    }

    // Constructor
    public Actor(String name, int strength, int constitution, int dexterity){
        this.name = name;
        this.strength = strength;
        this.constitution = constitution;
        this.dexterity = dexterity;

        attackPower = strength*2;
        maxHealth = constitution*10;
        currHealth = maxHealth;
        initiative = 0;

        locx=0;
        locy=0;
    }

    public String takeDamage(int damage){
        currHealth -= damage;
        return name + " has taken " + damage + " damage";
    }
    public String heal(int healedAmt){
        currHealth += healedAmt;
        return name + " has healed for " + healedAmt + " health";
    }

    public String attack(Actor someDude){// In the future have it take a Weapon object as a parameter
        someDude.takeDamage(this.attackPower);
        return this.name +" attacks "+ someDude.getName() + "\n" + someDude.getName() +" takes " + attackPower + " damage.";
    }

    public String showStats(){
        return "=== " + name + "'s Attributes ===\n" +
                "Strength: " + strength + "\n" +
                "Constitution: " + constitution + "\n" +
                "Dexterity: " + dexterity+"\n" +
                "Attack Power: " + attackPower + "\n";
    }


    public String move(String direction){
        switch (direction){
            case "n":
                locx--;
                return name + " moves north.";
            case "s":
                locx++;
                return name + " moves south.";
            case "e":
                locy++;
                return name + " moves east.";
            case "w":
                locy--;
                return name + " moves west.";
            default:
                return name + " stays put.";
        }
    }

    @Override
    public String toString() {
        return icon;
    }
}
