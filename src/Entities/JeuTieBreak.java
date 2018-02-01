import java.util.HashMap;

public class JeuTieBreak implements Jeu {

    HashMap<Player, PointsJeu> currentScore;

    @Override
    public String getCurrentPoints(Player pPlayer) {
        return currentScore.get(pPlayer).getScore();
    }

    @Override
    public void AddPoints(Player pPlayer) {

    }
}
