package campus.valence.board;

import campus.valence.CellStatus;
import campus.valence.hero.Hero;

public interface Cell {
    CellStatus open(Hero hero);
}
