package campus.valence;


import java.awt.*;

public class BigFireball extends Fireball {
    public BigFireball(int destroyerX) {
        setWidth(10);
        setHeight(10);
        setX(destroyerX+30);
        setY(450);
        panel.setBounds(getX(), getY(), getWidth(), getHeight());
        panel.setBackground(Color.green);
    }
}
