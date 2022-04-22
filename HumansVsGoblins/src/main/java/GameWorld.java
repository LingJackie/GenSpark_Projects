import java.nio.file.Files;
import java.util.Random;

public class GameWorld {

    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_RESET = "\u001B[0m";


    private String[][] worldMap;

    public void setTile(int x, int y, String emoji){
        worldMap[x][y] = emoji;
    } // Updates a tile at position x,y

    // Constructors
    public GameWorld(){
        generateRandMap(20);
    }
    public GameWorld(String[][] worldMap ){
        this.worldMap = worldMap;
    }


    // Creates a new world map of size: size x size
    // Randomly adds trees and stuff
    public void generateRandMap(int size){
        worldMap = new String[size][size];
        //rand.nextInt((max - min) + 1) + min
        Random rand = new Random();
        int randNum;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                randNum = rand.nextInt(size);
                if(randNum < (int)size/10){
                    worldMap[i][j] = ANSI_GREEN+"\uD83C\uDF32"+ANSI_RESET;
                }else{
                    worldMap[i][j] = ". ";
                }
            }
        }

    }

    @Override
    public String toString() {
        String tmp = "";
        for(String[] row:worldMap){
            for(String s:row){
                tmp+= " " + s;
            }
            tmp+="\n";
        }
        return tmp;
    }
}
