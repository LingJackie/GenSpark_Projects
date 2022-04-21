import java.nio.file.Files;
import java.util.Random;

public class GameWorld {

    String[][] worldMap;


    public void generateRandMap(int size){
        worldMap = new String[size][size];
        //rand.nextInt((max - min) + 1) + min
        Random rand = new Random();
        int randNum;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                randNum = rand.nextInt(size);
                if(randNum < (int)size/10){
                    worldMap[i][j] = "\uD83C\uDF32";
                }else{
                    worldMap[i][j] = ".";
                }
            }
        }

    }

    public GameWorld(){
        generateRandMap(30);
    }
    public GameWorld(String[][] worldMap ){
        this.worldMap = worldMap;
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
