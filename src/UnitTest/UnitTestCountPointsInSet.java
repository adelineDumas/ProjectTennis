import static org.junit.Assert.*;
import org.junit.*;


public class UnitTestCountPointsInSet {

    private Player playerJohan;
    private Player playerNicolas;
    private JeuNormal jeu;

    @Before
    public void init() {
        playerJohan = new Player("Johan");
        playerNicolas = new Player("Nicolas");
        jeu = new JeuNormal(playerJohan, playerNicolas);

    }

    @Test
    public void AddPointSet(){
        jeu.AddPoints(playerJohan);
        jeu.AddPoints(playerJohan);
        jeu.AddPoints(playerJohan);

        jeu.AddPoints(playerNicolas);
        jeu.AddPoints(playerNicolas);
        jeu.AddPoints(playerNicolas);


        jeu.AddPoints(playerJohan);

    }
}
