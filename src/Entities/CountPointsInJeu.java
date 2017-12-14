import java.util.HashMap;

public class CountPointsInJeu implements CountPointsIn {

    HashMap<Player, Points> currentScore;

    @Override
    public HashMap<Player, Points> getCurrentPoints(Player pPlayer) {
        return currentScore;
    }
}
