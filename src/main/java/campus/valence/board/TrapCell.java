package campus.valence.board;

import campus.valence.CellStatus;
import campus.valence.hero.Hero;

public class TrapCell implements Cell {
    @Override
    public CellStatus open(Hero hero) {
        throw new TrappedHeroException();
    }
}
