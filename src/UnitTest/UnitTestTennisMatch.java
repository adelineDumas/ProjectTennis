import static org.junit.Assert.*;
import org.junit.*;

public class UnitTestTennisMatch {

    private Player playerJohan;
    private Player playerNicolas;
    private TennisMatch match;


    @Before
    public void init(){
        playerJohan = new Player("Johan");
        playerNicolas = new Player("Nicolas");
        match = new TennisMatch(playerJohan, playerNicolas, MatchType.BEST_OF_THREE, false);
    }

    @Test
    public void TestGagneSet(){
        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);

        match.updateWithPointWonBy(playerJohan);
        match.updateWithPointWonBy(playerJohan);
        match.updateWithPointWonBy(playerJohan);
        match.updateWithPointWonBy(playerJohan);

        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);

        match.updateWithPointWonBy(playerNicolas);
        assertEquals("0", match.pointsForPlayer(playerNicolas));

        assertEquals(1, match.gamesInSetForPlayer(1, playerNicolas));
        assertEquals(0, match.gamesInSetForPlayer(1, playerJohan));
    }

    @Test
    public void TestCurrentSet(){
        assertEquals(1, match.currentSetNumber());

        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);

        assertEquals(1, match.currentSetNumber());

    }

    @Test
    public void TestGamesInSetForPlayer(){
        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);

        assertEquals(1, match.gamesInSetForPlayer(1, playerNicolas));

        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);

        assertEquals(2, match.gamesInSetForPlayer(1, playerNicolas));

    }

    @Test public void TestGamesInCurrentSetForplayer(){
        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);
        match.updateWithPointWonBy(playerNicolas);


        assertEquals(2, match.gamesInCurrentSetForPlayer(playerNicolas));
        assertEquals(0, match.gamesInCurrentSetForPlayer(playerJohan));
    }

    @Test public void TestEndMatch(){
        for (int i = 0 ; i<24 ; i++){
            match.updateWithPointWonBy(playerNicolas);
        }
        for (int i = 0 ; i<24 ; i++){
            match.updateWithPointWonBy(playerJohan);
        }
        for (int i = 0 ; i<24 ; i++){
            match.updateWithPointWonBy(playerNicolas);
        }
        assertEquals(true, match.endMatch());

    }



}
