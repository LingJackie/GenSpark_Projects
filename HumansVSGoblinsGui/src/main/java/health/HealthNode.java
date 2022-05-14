package health;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.FileNotFoundException;


public class HealthNode extends StackPane {
    
    private Rectangle heart;


    public void setHeartState(String state){
        switch (state){
            case "full":
                try{
                    setSprite("heart(full).png");
                }catch(Exception e){
                    heart.setFill(Color.RED);
                }
                break;
            case "half":
                try{
                    setSprite("heart(half).png");
                }catch(Exception e){
                    heart.setFill(Color.ORANGE);
                }
                break;
            case "empty":
                try{
                    setSprite("heart(empty).png");
                }catch(Exception e){
                    heart.setFill(Color.BLACK);
                }
                break;

        }

    }
    private void setSprite(String imgName) throws FileNotFoundException {
        Image img = new Image(getClass().getResourceAsStream(imgName));
        heart.setFill(new ImagePattern(img));
    }
    /*
        Constructor
        size -> Dimensions of the tile i.e. if size is 25 then tile would be 25x25
        x,y -> Coords on the grid
     */
    public HealthNode(double x, double y, int size){
        heart = new Rectangle(size,size);
        setHeartState("full");

        // set position
        setTranslateX(x);
        setTranslateY(y);
        getChildren().addAll(heart);
    }

}
