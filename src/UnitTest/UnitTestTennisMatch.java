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


}
