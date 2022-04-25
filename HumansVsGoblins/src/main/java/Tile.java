public class Tile {

    private final String CROSSED_SWORDS_EMOJI = "\u2694";
    protected final String ANSI_RED = "\u001B[31m";
    protected final String ANSI_RESET = "\u001B[0m";

    private String baseLandscape;
    private String actorIcon;
    private boolean combatMarker;

    // Sets the tile to an actors icon
    public String setActorIcon(String actor_icon){
        this.actorIcon = actor_icon;
        return this.toString();
    }
    public String clearActorIcon(){
        this.actorIcon = "";
        return this.toString();
    }

    // Toggles if combat is occurring on this tile
    public String toggleCombatMarker(){
        combatMarker = combatMarker? false: true;
        return this.toString();
    }


    // Constructor initialize with landscape symbol
    public Tile(String baseLandscape){
        this.baseLandscape =baseLandscape;
        this.actorIcon = "";
        this.combatMarker = false;
    }

    @Override
    public String toString() {
        if(combatMarker){
            return ANSI_RED+CROSSED_SWORDS_EMOJI+ANSI_RESET;
        }else if(actorIcon.equals("")){
            return baseLandscape;
        }else{
            return actorIcon;
        }
    }
}
