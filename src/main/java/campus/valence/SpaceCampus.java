package campus.valence;

import javax.swing.*;
import java.awt.*;

public class SpaceCampus {

    private JFrame frame;
    private JPanel panel;
    private Destroyer destroyer;

    SpaceCampus() {
        panel = new JPanel();
        panel.setFocusable(true);
        panel.setLayout(null);

        frame = new JFrame();
        frame.setTitle("SPACE CAMPUS");
        frame.setSize(400, 600);
        frame.setContentPane(panel);

        createDestroyer();
        createBlocks();
    }

    public void launch() {
        this.frame.setVisible(true);
    }

    private void createDestroyer() {
        destroyer = new Destroyer();
        this.panel.add(destroyer.getPanel());
        this.panel.addKeyListener(new GameKeyListener(destroyer));
    }

    private void createBlocks() {
        JPanel panel1 = new JPanel();
        panel1.setBounds(5, 5, 80, 30);
        panel1.setBackground(Color.BLUE);
        this.panel.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setBounds(100, 5, 80, 30);
        panel2.setBackground(Color.BLUE);
        this.panel.add(panel2);
    }
}
