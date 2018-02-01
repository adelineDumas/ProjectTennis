import java.util.HashMap;

public class JeuNormal implements Jeu {

    //region variable

    HashMap<Player, PointsJeu> currentScore;

    //endregion

    //region constructeur

    public JeuNormal(Player pPlayer1, Player pPlayer2) {
        currentScore = new HashMap<>();
        currentScore.put(pPlayer1, new PointsJeu("0"));
        currentScore.put(pPlayer2, new PointsJeu("0"));
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
        Player player2 = new Player("");
        for (HashMap.Entry<Player,PointsJeu> entry : currentScore.entrySet()) {
            Player key = entry.getKey();
            if (! key.getName().equals(pPlayer.getName())) {
                player2 = key;
            }
        }
        if (currentScore.get(player2).getScore().equals("A") && currentScore.get(pPlayer).getScore().equals("40")){
            currentScore.get(player2).DiminuePoint();
        }
        else {
            currentScore.get(pPlayer).AugmentePoints();
        }
        if (currentScore.get(player2).getScore().equals("A") && !currentScore.get(pPlayer).getScore().equals("40")){
            currentScore.get(player2).AugmentePoints();
        }

    }

    //endregion


}
