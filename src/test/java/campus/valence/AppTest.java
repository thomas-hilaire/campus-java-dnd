package campus.valence;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        
    	Dice dice = new RandomDice();
		HeroDatabase heroDatabase = new ImMemoryHeroDatabase();
		
		Game game = new Game(dice);
    	
    	// game.playTurn();
    	
    	// assert
    }

}
