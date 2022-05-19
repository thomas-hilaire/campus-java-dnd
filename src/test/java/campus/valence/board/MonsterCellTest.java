package campus.valence.board;

import campus.valence.CellStatus;
import campus.valence.hero.Hero;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonsterCellTest {

    @Test
    public void shouldKillMonsterWhenWeakerThanHero() {
        // Given
        Cell cell = new MonsterCell("gobelin", 1, 1);
        Hero hero = new Hero("Sergei", 1, 10);

        // When
        CellStatus status = cell.open(hero);

        // Then
        assertEquals(CellStatus.CLEAR, status);
        assertEquals(10, hero.getLife());
    }

    @Test
    public void shouldNotKillMonsterWhenStrongerThanHero() {
        // Given
        Cell cell = new MonsterCell("gobelin", 10, 5);
        Hero hero = new Hero("Sergei", 5, 10);

        // When
        CellStatus status = cell.open(hero);

        // Then
        assertEquals(CellStatus.RUNNING, status);
        assertEquals(5, hero.getLife());
    }
}