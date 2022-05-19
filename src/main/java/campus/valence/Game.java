package campus.valence;

import campus.valence.board.*;
import campus.valence.controller.GameController;
import campus.valence.hero.Hero;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

import java.util.Arrays;
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
                new TrapCell(),
                new MonsterCell("sorcer", 6, 3),
                new PotionCell(5),
                new MonsterCell("dragon", 8, 4)
        );
    }

    Hero chooseHero(GameController controller) {
        String name = controller.askQuestion("Give a name to your hero");
        int strength = controller.askIntQuestion("Strength?");
        int life = controller.askIntQuestion("How many life points?");

        return new Hero(name, strength, life);
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

        // NEW RULE: a cell can be locked the first time you try to open it,
        // opening it removes the lock but move your hero one cell backward
        // => new LockedCellException

        // NEW RULE: a trap cell, resetting your position to the first case
        // => new TrappedException (RuntimeException)
        try {
            CellStatus status = cell.open(hero);
            while (status == CellStatus.RUNNING) {
                status = cell.open(hero);
            }
        } catch (TrappedHeroException exception) {
            position = 0;
        } catch (Exception exception) {
            System.out.println("Erreur non gérée" + exception.getMessage());
        }

    }
}