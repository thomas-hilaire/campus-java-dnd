package campus.valence.controller;

import campus.valence.board.Cell;

public class TerminalGameController implements  GameController{
    @Override
    public void notifyDiceThrow() {
        System.out.println("Lancer de dé ..!");
    }

    @Override
    public void notifyWinner() {
        System.out.println("Vous avez gagné!");
    }

    @Override
    public void notifyLooser() {
        System.out.println("Vous avez perdu!");
    }

    @Override
    public void notifyCell(int position, Cell cell) {
        System.out.println("Vous ouvrer la cellule #" + position + ". Vous tombez sur " + cell);
    }

    @Override
    public String askQuestion(String question) {
        System.out.println(question);

        return null;
    }

    @Override
    public int askIntQuestion(String question) {
        return 0;
    }
}
