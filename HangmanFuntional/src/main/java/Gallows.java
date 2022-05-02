import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gallows {
    private int state;// 0 - 6; with 0 the gallows is empty and 6 being the full stick man is in the gallows

    private ArrayList<String> gallowsList;
    private ArrayList<String> currentGallows;


    public ArrayList<String> getGallowsList() { return this.gallowsList; }
    public int getState() { return this.state; }



    public Gallows(int state){
        this.readGallowsAscii();
        this.setState(state);
    }


    // Increases the state by one and updates the ascii representation of the gallows
    public String incrementState(){
        if(state < 6){
            addLimb(++state);
        }
        return this.toString();
    }

    // Initializes the state for the constructor
    private void setState(int state){
        if(state > 6){
            this.state = 6;
            addLimb(6);
        }else if(state < 0){
            this.state = 0;
            addLimb(0);
        }else{
            this.state = state;
            addLimb(state);
        }
    }

    // Grabs the gallows ascii art from a file for the constructor
    private void readGallowsAscii() {
        try{
            List<String> words = Files.readAllLines(Paths.get("src/main/resources/gallows.txt"));
            gallowsList = new ArrayList<String>(words);
        }catch (IOException e){
            gallowsList = new ArrayList<String>(Arrays.asList("b","r","o","k","e","n","b","r","o","k","e","n","b","r","o","k","e","n","b","r","o","k","e","n","b","r","o","k","e","n","b","r","o","k","e","n","b","r","o","k","e","n","b","r","o","k","e","n","b","r","o","k","e","n","b","r","o","k","e","n","b","r","o","k","e","n"));
        }

    }

    // Adds a limb to the ascii gallows art
    private void addLimb(int state){
        switch (state){
            case 0:
                currentGallows = new ArrayList<String>(gallowsList.subList(0,7));
                break;
            case 1:
                currentGallows = new ArrayList<String>(gallowsList.subList(7,14));
                break;
            case 2:
                currentGallows = new ArrayList<String>(gallowsList.subList(14,21));
                break;
            case 3:
                currentGallows = new ArrayList<String>(gallowsList.subList(21,28));
                break;
            case 4:
                currentGallows = new ArrayList<String>(gallowsList.subList(28,35));
                break;
            case 5:
                currentGallows = new ArrayList<String>(gallowsList.subList(35,42));
                break;
            case 6:
                currentGallows = new ArrayList<String>(gallowsList.subList(42,49));
                break;
        }
    }

    @Override
    public String toString() {
        return currentGallows.stream().reduce("", (partialGallows, elem) -> partialGallows+elem+"\n");
    }

}
