package eventHandlers;

import com.example.gamegui.HVG;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class PlayerMovementHandler implements EventHandler<KeyEvent>{
    private HVG game;
    public PlayerMovementHandler(HVG game){
        this.game = game;
    }

    @Override
    public void handle(KeyEvent key) {
        switch (key.getCode()){
            case UP:
                game.getPlayer().moveActor("n");
                break;
            case DOWN:
                game.getPlayer().moveActor("s");
                break;
            case LEFT:
                game.getPlayer().moveActor("w");
                break;
            case RIGHT:
                game.getPlayer().moveActor("e");
                break;
        }
    }

}
