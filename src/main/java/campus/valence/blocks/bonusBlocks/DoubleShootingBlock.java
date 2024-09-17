package campus.valence.blocks.bonusBlocks;

import campus.valence.Destroyer;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class DoubleShootingBlock extends BonusBlock {

    public DoubleShootingBlock(Destroyer destroyer, JPanel panel) {
        super(destroyer, panel);
        setWidth(10);
        setHeight(10);
        setSpeed(5);
        setX((int) Math.floor(Math.random() * 290 + 30));
        setY(0);
        getOneBlockPanel().setBounds(getX(), getY(), getWidth(), getHeight());
        getOneBlockPanel().setBackground(Color.GRAY);
    }

    @Override
    public void blockInteraction() {
        getPanel().remove(getOneBlockPanel());
        getDestroyer().setDoubleShootingBonus(true);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getDestroyer().setDoubleShootingBonus(false);
            }
        },6000);


    }
}
