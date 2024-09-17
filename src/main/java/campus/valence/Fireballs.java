package campus.valence;



import campus.valence.blocks.enemiesBlocks.EnemyBlock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;

public class Fireballs extends AbstractAction {

    private JPanel panel;
    private JLabel jlabel = new JLabel("0");

    private Set<Fireball> fireballs;
    private Set<EnemyBlock> blocks;
    private int score = 0;



    public Fireballs(JPanel panel, Set<EnemyBlock> blocks) {
        fireballs = new HashSet<>();
        this.blocks = blocks;
        this.panel = panel;
        jlabel.setFont(new Font("Verdana", Font.BOLD,20));
        jlabel.setBounds(200,200,200 ,200);
        panel.add(jlabel);


        Timer timer = new Timer(4, this);
        timer.setRepeats(true);
        timer.start();
    }

    public void send(Fireball fireball) {
        fireballs.add(fireball);
        panel.add(fireball.panel);
        panel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JPanel fireballToRemove = null;
        EnemyBlock blockToRemove = null;
        oneFireballHit:
        for (Fireball fireball : fireballs) {
            for (EnemyBlock block : blocks){
                if (fireball.getPanel().getBounds().intersects(block.getOneBlockPanel().getBounds())) {
                    block.setHealth(block.getHealth()-1);
                    if (block.getHealth()<=0) {
                        score += block.getValue();
                        panel.remove(block.getOneBlockPanel());
                        blockToRemove = block;
                        jlabel.setText(String.valueOf(score));
                        panel.add(jlabel);
                    } else {
                        block.getLifePoints().setText(String.valueOf(block.getHealth()));
                    }
                    fireballToRemove = fireball.getPanel();
                    fireballs.remove(fireball);
                    break oneFireballHit;
                }
            }
            fireball.moveForward();
        }
        if (fireballToRemove != null){
            blocks.remove(blockToRemove);
            panel.remove(fireballToRemove);
            panel.revalidate();
            panel.repaint();
        }

    }
    public int getScore() {
        return score;
    }
}
