package campus.valence.board;

import campus.valence.CellStatus;
import campus.valence.hero.Hero;

public class PotionCell implements Cell {

    int points;

    public PotionCell(int points) {
        this.points = points;
    }

    @Override
    public CellStatus open(Hero hero) {
        hero.setLife(hero.getLife() + points);
        return CellStatus.CLEAR;
    }

    @Override
    public String toString() {
        return "PotionCell{" +
                "points=" + points +
                '}';
    }
}
