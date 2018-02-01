import java.util.HashMap;

/***
 * Permet de créer un jeu en mode TieBreak
 * @Author : Adeline Dumas - 14/12/2017 - Création
 */
public class JeuTieBreak implements Jeu {

    HashMap<Player, PointsJeu> currentScore;

    @Override
    public String getCurrentPoints(Player pPlayer) {
        return currentScore.get(pPlayer).getScore();
    }

    /***
     * Ajoute les points au joueur
     * S'il y a avantage pour les deux et que l'un marque, les deux repassent à 40
     * @param pPlayer
     */
    @Override
    public void AddPoints(Player pPlayer) {

    }
}
