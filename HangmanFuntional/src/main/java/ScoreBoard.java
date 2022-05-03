import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class ScoreBoard {
    private String name;
    private int score;

    public String getName() { return name; }
    public int getScore()   { return score; }

    public void setName(String name)   { this.name=name; }

    public ScoreBoard(String name){
        this.name =name;
        score = 0;
    }

    public void addScore(int score){
        this.score+=score;
    }

    // Saves score into a separate file
    public void saveScore() throws IOException {
        Files.write(Paths.get("src/main/resources/scoreBoard.txt"), (name+" "+score+"\n").getBytes(), StandardOpenOption.CREATE,StandardOpenOption.APPEND);
    }

    // Reads from file to find the highest score
    public String checkHighScore() throws IOException, IndexOutOfBoundsException {
        List<String> leaderBoard = Files.readAllLines(Paths.get("src/main/resources/scoreBoard.txt"));
        if(leaderBoard.isEmpty()){
            return "New High Score!(Only because its the only score.)";
        }
        ArrayList<String> tmp = leaderBoard.stream()
                                            .filter(entry -> Integer.parseInt( entry.split(" ")[1] ) >= score)
                                            .collect(Collectors.toCollection(ArrayList::new));
        if(tmp.isEmpty()){// Current score is highscore
            return "New High Score!";
        }else{
            return "";
        }

    }
}
