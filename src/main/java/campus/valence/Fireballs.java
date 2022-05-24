package campus.valence;



import campus.valence.blocks.Blocks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;

public class Fireballs extends AbstractAction {

    private JPanel panel;
    private JLabel jlabel = new JLabel("0");
    private int enemiesKilled = 0;

    private Set<Fireball> fireballs;
    private Set<Blocks> blocks;


    public Fireballs(JPanel panel, Set<Blocks> blocks) {
        fireballs = new HashSet<>();
        this.blocks = blocks;
        this.panel = panel;
        jlabel.setFont(new Font("Verdana",1,20));
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
        Blocks blockToRemove = null;
        oneFireballHit:
        for (Fireball fireball : fireballs) {
            for (Blocks block : blocks){
                if (fireball.getPanel().getBounds().intersects(block.getPanel().getBounds())) {
                    block.setHeath(block.getHeath()-1);
                    if (block.getHeath()<=0) {
                        enemiesKilled++;
                        panel.remove(block.getPanel());
                        blockToRemove = block;
                        jlabel.setText(String.valueOf(enemiesKilled));
                        panel.add(jlabel);
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
}
