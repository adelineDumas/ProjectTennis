import java.util.HashMap;

public class JeuNormal implements Jeu {

    //region variable

    HashMap<Player, Points> currentScore;

    //endregion

    //region constructeur

    public JeuNormal(Player pPlayer1, Player pPlayer2) {
        currentScore = new HashMap<>();
        currentScore.put(pPlayer1, new Points("0"));
        currentScore.put(pPlayer2, new Points("0"));
    }

    //endregion

    //region methodes

    @Override
    public String getCurrentPoints(Player pPlayer) {
        return currentScore.get(pPlayer).getScore();
    }

    /***
     * Ajoute les points au joueur
     * S'il y a avantage pour les deux et que l'un marque, les deux repassent à 40
     * @param pPlayer
     */
    public void AddPoints(Player pPlayer){
        currentScore.get(pPlayer).AugmentePoints();
        for (HashMap.Entry<Player,Points> entry : currentScore.entrySet()) {
            Player key = entry.getKey();
            currentScore.get(key).DiminuePoint();
            
        }
    }

    //endregion


}
