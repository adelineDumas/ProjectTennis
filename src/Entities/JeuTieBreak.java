import java.util.HashMap;

public class JeuTieBreak implements Jeu {

    HashMap<Player, Points> currentScore;

    @Override
    public String getCurrentPoints(Player pPlayer) {
        return currentScore.get(pPlayer).getScore();
    }
}
