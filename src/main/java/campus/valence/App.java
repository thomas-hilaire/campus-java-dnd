package campus.valence;

import campus.valence.controller.GameController;
import campus.valence.controller.TerminalGameController;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		Injector injector = Guice.createInjector(new DndModule());

		Game game = injector.getInstance(Game.class);
        GameController controller = new TerminalGameController();

		GameStatus status = GameStatus.RUNNING;
        while (status == GameStatus.RUNNING) {
            status = game.playTurn(controller);
        }

        switch (status) {
            case SUCCESS:
                controller.notifyWinner();
                break;
            case FAILED:
                controller.notifyLooser();
                break;
        }
    }
}
