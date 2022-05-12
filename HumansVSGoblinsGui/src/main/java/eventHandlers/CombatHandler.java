package eventHandlers;

import com.example.gamegui.HVG;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class CombatHandler implements EventHandler<KeyEvent> {
    HVG game;
    public CombatHandler(HVG game){
        this.game=game;
    }

    @Override
    public void handle(KeyEvent keyEvent) {

    }
}
