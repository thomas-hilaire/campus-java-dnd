package campus.valence;

import campus.valence.blocks.Blocks;
import campus.valence.blocks.FastBlock;
import campus.valence.blocks.HugeBlock;
import campus.valence.blocks.SlowBlock;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;

public class SpaceCampus extends AbstractAction {

    private final Fireballs fireballs;
    private JFrame frame;
    private JPanel panel;
    private JPanel destroyer;
    private Set<Blocks> blocks = new HashSet<>();

    SpaceCampus() {
        panel = new JPanel();
        panel.setFocusable(true);
        panel.setLayout(null);

        frame = new JFrame();
        frame.setTitle("SPACE CAMPUS");
        frame.setSize(400, 600);
        frame.setContentPane(panel);
        fireballs = new Fireballs(this.panel, blocks);
        createBlocks();
        createDestroyer();


    }

    public void launch() {
        this.frame.setVisible(true);
    }

    private void createDestroyer() {
        Destroyer destroyer = new Destroyer(fireballs);
        this.destroyer = destroyer.getPanel();
        this.panel.add(destroyer.getPanel());
        this.panel.addKeyListener(new GameKeyListener(destroyer));
    }

    private void createBlocks() {



        Timer timer = new Timer(700, this);
        timer.setRepeats(true);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int random = (int) Math.floor(Math.random()*5);
        Blocks newBlock = null;
        if (random > 3){
            newBlock = new HugeBlock(this.destroyer,blocks);

        } else if (random >1){
            newBlock = new FastBlock(this.destroyer,blocks);
        } else {
            newBlock = new SlowBlock(this.destroyer,blocks);
        }

        this.panel.add(newBlock.getPanel());
        this.blocks.add(newBlock);
    }

}
