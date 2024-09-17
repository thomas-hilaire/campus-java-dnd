package campus.valence.blocks.enemiesBlocks;


import campus.valence.Destroyer;
import campus.valence.blocks.Block;

import javax.swing.*;


public abstract class EnemyBlock extends Block {
    JLabel lifePoints = new JLabel("1", JLabel.CENTER);


    private int value;
    private int health;


    public EnemyBlock(Destroyer destroyer, JPanel panel) {
        super(destroyer, panel);
    }


    @Override
    public void blockInteraction() {
        if (getHealth()>0) {
            System.out.println("game over");
            System.exit(0);
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public JLabel getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(JLabel lifePoints) {
        this.lifePoints = lifePoints;
    }


}
