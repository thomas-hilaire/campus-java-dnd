package campus.valence;

public class RandomDice implements Dice {

	@Override
	public int next() {
		return (int) Math.round(Math.random() * 6);
	}

}
