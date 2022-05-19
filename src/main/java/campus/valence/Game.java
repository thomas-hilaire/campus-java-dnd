package campus.valence;

import campus.valence.board.Cell;
import campus.valence.board.MonsterCell;
import campus.valence.board.PotionCell;
import campus.valence.controller.GameController;
import campus.valence.hero.Hero;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

import java.util.List;

public class Game {

    private Dice dice;
    private final Hero hero;
    private List<Cell> board;
    private int position;

    @Inject
    Game(Dice dice) {
        this.dice = dice;
        this.hero = new Hero("Sergei", 8, 10);
        this.board = Lists.newArrayList(
                new MonsterCell("gobelin", 3, 2),
                new MonsterCell("gobelin", 3, 2),
                new MonsterCell("gobelin", 3, 2),
                new PotionCell(3),
                new MonsterCell("gobelin", 4, 2),
                new MonsterCell("gobelin", 4, 2),
                new PotionCell(5),
                new MonsterCell("sorcer", 6, 3),
                new PotionCell(5),
                new MonsterCell("dragon", 8, 4)
        );
    }

    GameStatus playTurn(GameController controller) {
        controller.notifyDiceThrow();
        position = position + dice.next();

        if (position > board.size()) {
            return GameStatus.SUCCESS;
        }

        openCurrentCell(controller);

        if (hero.getLife() < 1) {
            return GameStatus.FAILED;
        }
        return GameStatus.RUNNING;
    }

    private void openCurrentCell(GameController controller) {
        Cell cell = this.board.get(position);
        controller.notifyCell(position, cell);
        CellStatus status = cell.open(hero);

        while (status == CellStatus.RUNNING) {
            status = cell.open(hero);
        }
    }
}