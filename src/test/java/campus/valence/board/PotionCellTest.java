package campus.valence.board;

import campus.valence.CellStatus;
import campus.valence.hero.Hero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PotionCellTest {

    @Test
    public void shouldHealHero() {
        // Given
        Cell cell = new PotionCell(3);
        Hero hero = new Hero("Sergei", 1, 10);

        // When
        CellStatus status = cell.open(hero);

        // Then
        assertEquals(CellStatus.CLEAR, status);
        assertEquals(13, hero.getLife());
    }

}