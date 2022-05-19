package campus.valence;

public interface HeroDatabase {

	void saveHero(Object hero);
	Object loadHero(int id);
}
