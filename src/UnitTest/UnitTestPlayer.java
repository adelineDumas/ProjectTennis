import static org.junit.Assert.*;
import org.junit.*;

public class UnitTestPlayer {

    private Player player1;
    private Player player2;

    @Before
    public void init(){
        player1 = new Player("Nico");
        player2 = new Player("Johan");
    }

    @Test
    public void testCreatePlayer(){
        assertEquals("Nico", player1.getName());
        assertEquals("Johan", player2.getName());
    }
}
