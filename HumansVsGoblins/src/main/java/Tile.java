public class Tile {
    private String baseLandscape;
    private String actorIcon;

    // Sets the tile to an actors icon
    public String setActorIcon(String actor_icon){
        this.actorIcon = actor_icon;
        return this.toString();
    }

    public String clearActorIcon(){
        this.actorIcon = "";
        return this.toString();
    }

    // Constructor initialize with landscape symbol
    public Tile(String baseLandscape){
        this.baseLandscape =baseLandscape;
        this.actorIcon = "";
    }

    @Override
    public String toString() {
        if(actorIcon.equals("")){
            return baseLandscape;
        }else{
            return actorIcon;
        }
    }
}
