public class GameWorld {


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
    public GameWorld()                      { generateRandMap(4); }
    public GameWorld(int worldSize)         { generateRandMap(worldSize); }
    public GameWorld(Tile[][] worldMap)     { this.worldMap = worldMap; }


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
                    worldMap[i][j] = new Tile(ColorAndEmoji.WATER);
                } else if (noiseVal < -.25) {// Sand
                    worldMap[i][j] = new Tile(ColorAndEmoji.SAND);
                } else if (noiseVal < 0) {// Grasslands
                    worldMap[i][j] = new Tile(ColorAndEmoji.GRASS);
                } else if (noiseVal < .2) {// Forest1
                    worldMap[i][j] = new Tile(ColorAndEmoji.TREE1);
                } else if (noiseVal < .3) {// Forest2
                    worldMap[i][j] = new Tile(ColorAndEmoji.TREE2);
                } else if (noiseVal < .4) {// Low Hills
                    worldMap[i][j] = new Tile(ColorAndEmoji.LOW_HILL);
                } else if (noiseVal < .6) {// Tall Hills
                    worldMap[i][j] = new Tile(ColorAndEmoji.TALL_HILL);
                } else if (noiseVal <= 1) {// Mountain
                    worldMap[i][j] = new Tile(ColorAndEmoji.MOUNTAIN);
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
