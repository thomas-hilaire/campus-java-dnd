package campus.valence.board;

import campus.valence.CellStatus;
import campus.valence.hero.Hero;

public class MonsterCell implements Cell {

    String name;
    int points;
    int attack;

    public MonsterCell(String name, int points, int attack) {
        this.name = name;
        this.points = points;
        this.attack = attack;
    }

    @Override
    public CellStatus open(Hero hero) {
        this.points -= hero.getStrenght();

        if (this.points <= 0) {
            return CellStatus.CLEAR;
        }

        hero.setLife(hero.getLife() - attack);
        return CellStatus.RUNNING;
    }

    @Override
    public String toString() {
        return "MonsterCell{" +
                "name='" + name + '\'' +
                ", points=" + points +
                ", attack=" + attack +
                '}';
    }
}
