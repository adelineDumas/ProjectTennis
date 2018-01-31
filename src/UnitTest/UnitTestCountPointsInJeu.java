import static org.junit.Assert.*;
import org.junit.*;

public class UnitTestCountPointsInJeu {

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
    public void CountPointsInit() {
        Assert.assertEquals("0", jeu.getCurrentPoints(playerJohan));
        Assert.assertEquals("0", jeu.getCurrentPoints(playerNicolas));
        Assert.assertNotEquals("15", jeu.getCurrentPoints(playerJohan));
        Assert.assertNotEquals("15", jeu.getCurrentPoints(playerNicolas));
    }

    @Test
    public void CountPointsAdd() {
        jeu.AddPoints(playerJohan);
        Assert.assertEquals("15", jeu.getCurrentPoints(playerJohan));
        jeu.AddPoints(playerJohan);
        Assert.assertEquals("30", jeu.getCurrentPoints(playerJohan));
        jeu.AddPoints(playerJohan);
        Assert.assertEquals("40", jeu.getCurrentPoints(playerJohan));
    }

    @Test
    public void CountPointsLoose() {
        jeu.AddPoints(playerJohan);
        jeu.AddPoints(playerJohan);
        jeu.AddPoints(playerJohan);

        jeu.AddPoints(playerNicolas);
        jeu.AddPoints(playerNicolas);
        jeu.AddPoints(playerNicolas);

        jeu.AddPoints(playerJohan);
        jeu.AddPoints(playerNicolas);
        Assert.assertEquals("40", jeu.getCurrentPoints(playerJohan));
        Assert.assertEquals("40", jeu.getCurrentPoints(playerNicolas));

    }



}