public class Actor {


    protected final String DEAD_EMOJI ="\u2620";


    private String name;

    private int strength;// Determines damage dealt
    private int constitution;// Determines health
    private int dexterity;// Determines initiative

    private int attackPower;// Derived from strength and weapon stats
    private int maxHealth;// Derived from constitution and maybe armor


    private int currHealth;

    protected boolean playable;
    protected String icon;

    int x;// x location on map
    int y;// y location on map

    public String getHealthRatio()  { return currHealth +"/"+ maxHealth; }
    public String getName()         { return name; }
    public int getDexterity()       { return dexterity; }
    public int getX()               { return x; }
    public int getY()               { return y; }

    // Checks if actor is dead and updates icon to a skull if they are
    public String setDead(){
        icon = DEAD_EMOJI;
        return name + " has died.";
    }
    public void setLocation(int x, int y)   { this.x=x; this.y=y; }
    public void setName(String name)        { this.name = name;}

    public boolean isDead()     { return currHealth <= 0; }
    public boolean isPlayable() { return playable; }


    // Constructor
    public Actor(String name, int strength, int constitution, int dexterity){
        this.name = name;
        this.strength = strength;
        this.constitution = constitution;
        this.dexterity = dexterity;

        attackPower = strength;
        maxHealth = constitution*10;
        currHealth = maxHealth;

        x=0;
        y=0;
    }

    public String takeDamage(int damage){
        currHealth -= damage;
        currHealth = currHealth<0?0:currHealth;
        return name + " has taken " + damage + " damage";
    }
    public String heal(int healedAmt){
        currHealth += healedAmt;
        return name + " has healed for " + healedAmt + " health";
    }

    // Total damage should be attackPower+diceRoll+(weapon damage)
    public String attack(Actor someDude, int diceRoll){// In the future have it take a Weapon object as a parameter
        int totalDamageDealt = this.attackPower+diceRoll;
        someDude.takeDamage(totalDamageDealt);
        return this.name +" attacks "+ someDude.getName() + "\n" + someDude.getName() +" takes " + totalDamageDealt + " damage.";
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
                x--;
                return name + " moves north.";
            case "s":
                x++;
                return name + " moves south.";
            case "e":
                y++;
                return name + " moves east.";
            case "w":
                y--;
                return name + " moves west.";
            default:
                return name + " stays put.";
        }
    }

    public String displayHealthBar(){
        double ratio = (double)currHealth/maxHealth;
        String bar = "HP:"+ ColorAndEmoji.ANSI_RED;
        if(ratio <= .14){
            bar+="#"+ ColorAndEmoji.ANSI_RESET+"++++++";
        }else if(ratio <= .28){
            bar+="##"+ ColorAndEmoji.ANSI_RESET+"+++++";
        }else if(ratio <= .42){
            bar+="###"+ ColorAndEmoji.ANSI_RESET+"++++";
        }else if(ratio <= .56){
            bar+="####"+ ColorAndEmoji.ANSI_RESET+"+++";
        }else if(ratio <= .7){
            bar+="#####"+ ColorAndEmoji.ANSI_RESET+"++";
        }else if(ratio <= .84){
            bar+="######"+ ColorAndEmoji.ANSI_RESET+"+";
        }else{
            bar+="#######"+ ColorAndEmoji.ANSI_RESET;
        }
       return this.toString() + " " + name +"\n"+bar+" "+getHealthRatio();
    }

    @Override
    public String toString() {
        return icon;
    }
}
