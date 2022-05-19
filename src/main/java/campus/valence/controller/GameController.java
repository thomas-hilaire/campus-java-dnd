package campus.valence.controller;

import campus.valence.board.Cell;

public interface GameController {
    void notifyDiceThrow();
    void notifyWinner();
    void notifyLooser();
    void notifyCell(int position, Cell cell);
}
