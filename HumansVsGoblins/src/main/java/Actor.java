public class Actor {
    private String name;
    private int strength;// Determines damage dealt
    private int constitution;// Determines health
    private int dexterity;// Determines initiative

    private int attackPower;
    private int maxHealth;
    private int initiative;

    private int currHealth;


    public String getName() { return name;}

    public Actor(String name, int strength, int constitution, int dexterity){
        this.name = name;
        this.strength = strength;
        this.constitution = constitution;
        this.dexterity = dexterity;

        attackPower = strength*2;
        maxHealth = constitution*10;
        currHealth = maxHealth;
        initiative = 0;
    }

    public String takeDamage(int damage){
        currHealth -= damage;
        return name + " has taken " + damage + " damage";
    }

    public String attack(Actor someDude){// In the future have it take a Weapon object as a parameter
        return this.name +" attacked "+ someDude.getName() + "\n" + someDude.takeDamage(this.attackPower);
    }

    public String getStats(){
        return "=== " + name + "'s Attributes ===\n" +
                "Strength: " + strength + "\n" +
                "Constitution: " + constitution + "\n" +
                "Dexterity: " + dexterity+"\n" +
                "=== " + name + "'s Stats ===\n" +
                "Health: " + currHealth+ "/"+ maxHealth + "\n" +
                "Attack Power: " + attackPower + "\n";
    }




}
