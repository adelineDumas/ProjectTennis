import java.util.HashMap;

/***
 * Classe permettant de gérer l'évolution du score d'un match de tennis en fonction du joueur qui marque un point
 * @Author Adeline Dumas - 14/12/2017 Création
 */

public class TennisMatch {

    //region variable

    private Player player1;
    private Player player2;
    private MatchType matchType;
    private boolean tieBreakInLastSet;
    private Jeu jeu;
    private HashMap<Integer, PointsSet> scoreJeuPlayer1;
    private HashMap<Integer, PointsSet> scoreJeuPlayer2;

    //endregion

    //region constructeur

    public TennisMatch(Player pPlayer1, Player pPlayer2, MatchType pMatchType, boolean pTieBreakInLastSet){
        this.player1 = pPlayer1;
        this.player2 = pPlayer2;
        this.matchType = pMatchType;
        this.tieBreakInLastSet = pTieBreakInLastSet;

        jeu = new JeuNormal(pPlayer1, pPlayer2);

        this.scoreJeuPlayer1 = new HashMap<>();
        scoreJeuPlayer1.put(1, new PointsSet("0"));
        this.scoreJeuPlayer2 = new HashMap<>();
        scoreJeuPlayer2.put(1, new PointsSet("0"));


    }

    //endregion

    //region getters ou setters

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public boolean isTieBreakInLastSet() {
        return tieBreakInLastSet;
    }

    public void setTieBreakInLastSet(boolean tieBreakInLastSet) {
        this.tieBreakInLastSet = tieBreakInLastSet;
    }

    //endregion

    //region methodes

    /***
     * Met à jour le score du joueur passé en paramètre
     * @param pPlayer
     * @Author Adeline Dumas - 14/12/2017 - Création
     */
    public void updateWithPointWonBy(Player pPlayer){
        jeu.AddPoints(pPlayer);
        isFinished();
    }

    /***
     * Retourne le score du joueur passé en argument dans le jeu en cours ("40", "15", "A" pour avantage)
     * @param pPlayer
     * @return String
     * @Author - 14/12/2017
     */
    public String pointsForPlayer(Player pPlayer){
        System.out.println("Points :" + jeu.getCurrentPoints(pPlayer));
        return jeu.getCurrentPoints(pPlayer);
    }

    /***
     * Retourne le numéro du set actuel
     * @return int
     * @Author Adeline Dumas - 14/12/2017 - Création
     */
    public int currentSetNumber(){
        return 0;
    }

    /***
     * Retourne le nombre de jeu gagné par le joueur passé en argument dans le set en cours
     * @param pPlayer
     * @return int
     * @Author Adeline Dumas - 14/12/2017 - Création
     */
    public int gamesInCurrentSetForPlayer(Player pPlayer){
        return 0;
    }

    /***
     * Retourne le nombre de jeu gagné par le joueur passé en arguments dans le set dont le numéro est également passé en argument
     * @param pSetNumber
     * @param pPlayer
     * @return int
     * @Author Adeline Dumas - 14/12/2017 - Création
     */
    public int gamesInSetForPlayer(int pSetNumber, Player pPlayer){
        if (pPlayer.getName().equals(player1.getName())) {
            return Integer.parseInt(scoreJeuPlayer1.get(pSetNumber).getScore());
        }
        else {
            return Integer.parseInt(scoreJeuPlayer2.get(pSetNumber).getScore());
        }
    }

    /***
     * Détermine si le match est terminé
     * @return boolean
     * @Author Adeline Dumas - 14/12/2017 - Création
     */
    public boolean isFinished(){
        if (pointsForPlayer(player1) =="Gagné"){
            scoreJeuPlayer1.get(scoreJeuPlayer1.size()).AugmentePoints();
            System.out.println(player1.getName() + " gagne le jeu");
            jeu = new JeuNormal(player1, player2);
        }
        else if (pointsForPlayer(player2) =="Gagné"){
            scoreJeuPlayer2.get(scoreJeuPlayer2.size()).AugmentePoints();
            System.out.println(player2.getName() + " gagne le jeu");
            jeu = new JeuNormal(player1, player2);
        }
        return false;
    }

    //endregion
}
