package campus.valence.hero;

public class Hero {

    String name;
    int strenght;
    int life;

    public Hero(String name, int strenght, int life) {
        this.name = name;
        this.strenght = strenght;
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
