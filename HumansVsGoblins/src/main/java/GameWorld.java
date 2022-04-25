public class GameWorld {

    // COLORS
    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_CYAN = "\u001B[36m";
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_RESET = "\u001B[0m";

    // LANDSCAPE SYMBOLS
    private final String ALMOST_EQUALS_SYMBOL = "\u2248";// Sand/Water
    private final String SPADE_SYMBOL ="\u2660"; // Tree 1
    private final String CLUB_SYMBOL = 	"\u2663";// Tree 2
    private final String INTERSECTION_SYMBOL = "\u2229";// Big Hill
    private final String TRANGLE_SYMBOL =	"\u25B2";// Mountain
    


    private Tile[][] worldMap;
    
    // Updates a tile at position x,y with an actor's icon
    public void setActorMap(int x, int y, String actorIcon){
        worldMap[x][y].setActorIcon(actorIcon);
    }
    // Clears said actor's emoji
    public void clearActorMap(int x, int y){
        worldMap[x][y].clearActorIcon();
    }
    // When player and goblin overlap a crossed sword icon will appear there
    public void toggleMapCombatMarker(int x, int y){
        worldMap[x][y].toggleCombatMarker();
    }



    public boolean isOutOfBounds(int x, int y){
        try{
            Tile stuff = worldMap[x][y];
            return false;
        }catch(Exception e){
            return true;
        }
    }
    public int length(){
        return worldMap.length;
    }
    public int width(){
        return worldMap[0].length;
    }

    // Constructors
    public GameWorld(){
        generateRandMap(4);
    }
    public GameWorld(Tile[][] worldMap ){
        this.worldMap = worldMap;
    }


    // Creates a new world map of size: size x (size*3)
    // Uses perlin noise
    public void generateRandMap(int size){
        int length =size;
        int width = size*3;

        worldMap = new Tile[length][width];
        double scale = .045;// Play around with it should be under 0.1
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++) {
                double noiseVal = PerlinNoise.noise(i * scale, j * scale, 7);// Generates number between -1 and 1
                if (noiseVal < -.3) {// Water
                    worldMap[i][j] = new Tile(ANSI_BLUE + ALMOST_EQUALS_SYMBOL + ANSI_RESET);
                } else if (noiseVal < -.25) {// Sand
                    worldMap[i][j] = new Tile(ANSI_YELLOW + ALMOST_EQUALS_SYMBOL + ANSI_RESET);
                } else if (noiseVal < 0) {// Grasslands
                    worldMap[i][j] = new Tile(ANSI_GREEN + "=" + ANSI_RESET);
                } else if (noiseVal < .2) {// Forest1
                    worldMap[i][j] = new Tile(ANSI_GREEN + CLUB_SYMBOL + ANSI_RESET);
                } else if (noiseVal < .3) {// Forest2
                    worldMap[i][j] = new Tile(ANSI_GREEN + SPADE_SYMBOL + ANSI_RESET);
                } else if (noiseVal < .4) {// Low Hills
                    worldMap[i][j] = new Tile(ANSI_GREEN + "n" + ANSI_RESET);
                } else if (noiseVal < .6) {// Tall Hills
                    worldMap[i][j] = new Tile(ANSI_GREEN + INTERSECTION_SYMBOL + ANSI_RESET);
                } else if (noiseVal <= 1) {// Mountain
                    worldMap[i][j] = new Tile(TRANGLE_SYMBOL);
                }
            }
        }
    }

    @Override
    public String toString() {
        String tmp = "";
        for(Tile[] row:worldMap){
            for(Tile s:row){
                tmp+= s.toString();
            }
            tmp+="\n";
        }
        return tmp;
    }
}
