package campus.valence.blocks.enemiesBlocks;

import campus.valence.Destroyer;

import javax.swing.*;
import java.awt.*;

public class BossBlock extends EnemyBlock {
    public BossBlock(Destroyer destroyer, JPanel panel) {
        super(destroyer, panel);
        setValue(10);
        setHealth(50);
        setWidth(400);
        setHeight(100);
        setSpeed(1);
        setX(0);
        setY(0);
        getOneBlockPanel().setBounds(getX(), getY(), getWidth(), getHeight());
        getOneBlockPanel().setBackground(Color.BLACK);
        lifePoints.setText(String.valueOf(getHealth()));
        lifePoints.setForeground(Color.red);
        lifePoints.setFont(new Font("Verdana",1,40));
        lifePoints.setBounds(200,40,20 ,20);
        getOneBlockPanel().add(lifePoints);
        getOneBlockPanel().repaint();
        lifePoints.repaint();

    }
}
