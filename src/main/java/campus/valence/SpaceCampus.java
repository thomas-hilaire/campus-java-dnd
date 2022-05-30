package campus.valence;

import campus.valence.blocks.bonusBlocks.BonusBlock;
import campus.valence.blocks.bonusBlocks.DoubleShootingBlock;
import campus.valence.blocks.enemiesBlocks.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;

public class SpaceCampus extends AbstractAction {

    private final Fireballs fireballs;
    private JFrame frame;
    private JPanel panel;
    private Destroyer destroyer;
    private Set<EnemyBlock> enemyBlocks = new HashSet<>();
    static int score = 0;
    static int bossScore = 50;

    SpaceCampus() {
        panel = new JPanel();
        panel.setFocusable(true);
        panel.setLayout(null);

        frame = new JFrame();
        frame.setTitle("SPACE CAMPUS");
        frame.setSize(400, 600);
        frame.setContentPane(panel);
        fireballs = new Fireballs(this.panel, enemyBlocks);
        createBlocks();
        createDestroyer();


    }

    public void launch() {
        this.frame.setVisible(true);
    }

    private void createDestroyer() {
        Destroyer destroyer = new Destroyer(fireballs);
        this.destroyer = destroyer;
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
        EnemyBlock newEnemyBlock;
        score = fireballs.getScore();
        if (score >= bossScore) {
            bossScore += 50;
            newEnemyBlock = new BossBlock(this.destroyer,this.panel);
        } else {
            int random = (int) Math.floor(Math.random() * 5);
            if (random > 3) {
                newEnemyBlock = new HugeBlock(this.destroyer, this.panel);
            } else if (random > 1) {
                newEnemyBlock = new FastBlock(this.destroyer, this.panel);
            } else {
                newEnemyBlock = new SlowBlock(this.destroyer, this.panel);
            }
        }
        this.panel.add(newEnemyBlock.getOneBlockPanel());
        this.enemyBlocks.add(newEnemyBlock);
        BonusBlock newBonusBlock = null;
        int random = (int) Math.floor(Math.random() * 15);
        if (random == 0) {
            newBonusBlock = new DoubleShootingBlock(this.destroyer, this.panel);
        }
        if (newBonusBlock != null) {
            this.panel.add(newBonusBlock.getOneBlockPanel());
        }

    }

}
