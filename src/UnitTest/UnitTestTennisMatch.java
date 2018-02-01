import static org.junit.Assert.*;
import org.junit.*;

public class UnitTestTennisMatch {

    private Player playerJohan;
    private Player playerNicolas;
    private TennisMatch match3Set;
    private TennisMatch match5Set;


    @Before
    public void init(){
        playerJohan = new Player("Johan");
        playerNicolas = new Player("Nicolas");
        match3Set = new TennisMatch(playerJohan, playerNicolas, MatchType.BEST_OF_THREE, false);
        match5Set = new TennisMatch(playerJohan, playerNicolas, MatchType.BEST_OF_FIVE, false);
    }

    @Test
    public void TestGagneSet(){
        match3Set.updateWithPointWonBy(playerNicolas);
        match3Set.updateWithPointWonBy(playerNicolas);
        match3Set.updateWithPointWonBy(playerNicolas);

        match3Set.updateWithPointWonBy(playerJohan);
        match3Set.updateWithPointWonBy(playerJohan);
        match3Set.updateWithPointWonBy(playerJohan);
        match3Set.updateWithPointWonBy(playerJohan);

        match3Set.updateWithPointWonBy(playerNicolas);
        match3Set.updateWithPointWonBy(playerNicolas);

        match3Set.updateWithPointWonBy(playerNicolas);
        assertEquals("0", match3Set.pointsForPlayer(playerNicolas));

        assertEquals(1, match3Set.gamesInSetForPlayer(1, playerNicolas));
        assertEquals(0, match3Set.gamesInSetForPlayer(1, playerJohan));
    }

    @Test
    public void TestCurrentSet(){
        assertEquals(1, match3Set.currentSetNumber());

        match3Set.updateWithPointWonBy(playerNicolas);
        match3Set.updateWithPointWonBy(playerNicolas);
        match3Set.updateWithPointWonBy(playerNicolas);
        match3Set.updateWithPointWonBy(playerNicolas);

        assertEquals(1, match3Set.currentSetNumber());

    }

    @Test
    public void TestGamesInSetForPlayer(){
        match3Set.updateWithPointWonBy(playerNicolas);
        match3Set.updateWithPointWonBy(playerNicolas);
        match3Set.updateWithPointWonBy(playerNicolas);
        match3Set.updateWithPointWonBy(playerNicolas);

        assertEquals(1, match3Set.gamesInSetForPlayer(1, playerNicolas));

        match3Set.updateWithPointWonBy(playerNicolas);
        match3Set.updateWithPointWonBy(playerNicolas);
        match3Set.updateWithPointWonBy(playerNicolas);
        match3Set.updateWithPointWonBy(playerNicolas);

        assertEquals(2, match3Set.gamesInSetForPlayer(1, playerNicolas));

    }

    @Test public void TestGamesInCurrentSetForplayer(){
        for (int i = 0 ; i<8 ; i++){
            match3Set.updateWithPointWonBy(playerNicolas);
        }


        assertEquals(2, match3Set.gamesInCurrentSetForPlayer(playerNicolas));
        assertEquals(0, match3Set.gamesInCurrentSetForPlayer(playerJohan));
    }

    @Test public void TestEndMatch3Sets(){
        for (int i = 0 ; i<24 ; i++){
            match3Set.updateWithPointWonBy(playerNicolas);
        }
        for (int i = 0 ; i<24 ; i++){
            match3Set.updateWithPointWonBy(playerJohan);
        }
        for (int i = 0 ; i<24 ; i++){
            match3Set.updateWithPointWonBy(playerNicolas);
        }
        assertEquals(true, match3Set.endMatch());

    }

    @Test public void TestEndMatch5Sets(){
        for (int i = 0 ; i<24 ; i++){
            match5Set.updateWithPointWonBy(playerNicolas);
        }
        for (int i = 0 ; i<24 ; i++){
            match5Set.updateWithPointWonBy(playerJohan);
        }
        for (int i = 0 ; i<24 ; i++){
            match5Set.updateWithPointWonBy(playerNicolas);
        }
        for (int i = 0 ; i<24 ; i++){
            match5Set.updateWithPointWonBy(playerJohan);
        }
        for (int i = 0 ; i<24 ; i++){
            match5Set.updateWithPointWonBy(playerNicolas);
        }
        for (int i = 0 ; i<24 ; i++){
            match5Set.updateWithPointWonBy(playerNicolas);
        }
        for (int i = 0 ; i<24 ; i++){
            match5Set.updateWithPointWonBy(playerNicolas);
        }
        assertEquals(true, match5Set.endMatch());

    }



}
