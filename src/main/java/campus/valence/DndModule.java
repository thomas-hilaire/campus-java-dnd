package campus.valence;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class DndModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Dice.class).to(RandomDice.class);
	}
}
