package campus.valence.blocks.enemiesBlocks;



import campus.valence.Destroyer;

import javax.swing.*;
import java.awt.*;

public class HugeBlock extends EnemyBlock {

    public HugeBlock(Destroyer destroyer, JPanel panel) {
        super(destroyer, panel);
        setValue(5);
        setHealth(20);
        setWidth(60);
        setHeight(60);
        setSpeed(1);
        setX((int) Math.floor(Math.random() * 250 + 60));
        setY(0);
        getOneBlockPanel().setBounds(getX(), getY(), getWidth(), getHeight());
        getOneBlockPanel().setBackground(Color.MAGENTA);
        lifePoints.setText(String.valueOf(getHealth()));
        lifePoints.setFont(new Font("Verdana",1,20));
        lifePoints.setBounds(20,20,20 ,20);
        getOneBlockPanel().add(lifePoints);
        getOneBlockPanel().repaint();
        lifePoints.repaint();

    }
}
