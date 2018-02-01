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
        //System.out.println("Points :" + jeu.getCurrentPoints(pPlayer));
        return jeu.getCurrentPoints(pPlayer);
    }

    /***
     * Retourne le numéro du set actuel
     * @return int
     * @Author Adeline Dumas - 14/12/2017 - Création
     */
    public int currentSetNumber(){
        return scoreJeuPlayer1.size();
    }

    /***
     * Retourne le nombre de jeu gagné par le joueur passé en argument dans le set en cours
     * @param pPlayer
     * @return int
     * @Author Adeline Dumas - 14/12/2017 - Création
     */
    public int gamesInCurrentSetForPlayer(Player pPlayer){
        if (pPlayer.getName().equals(player1.getName())) {
            return Integer.parseInt(scoreJeuPlayer1.get(scoreJeuPlayer1.size()).getScore());
        }
        else {
            return Integer.parseInt(scoreJeuPlayer2.get(scoreJeuPlayer2.size()).getScore());
        }
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
        if (!endMatch()) {
            if (pointsForPlayer(player1).equals("Gagné")) {
                scoreJeuPlayer1.get(scoreJeuPlayer1.size()).AugmentePoints();
                System.out.println(gamesInCurrentSetForPlayer(player1) + " - " + gamesInCurrentSetForPlayer(player2) + " pour " + player1.getName());
                if (endSet()) {
                    NewSet();
                }
                jeu = new JeuNormal(player1, player2);
            } else if (pointsForPlayer(player2).equals("Gagné")) {
                scoreJeuPlayer2.get(scoreJeuPlayer2.size()).AugmentePoints();
                System.out.println(gamesInCurrentSetForPlayer(player2) + " - " + gamesInCurrentSetForPlayer(player1) + " pour " + player2.getName());
                if (endSet()) {
                    NewSet();
                }
                jeu = new JeuNormal(player1, player2);
            }
            return false;
        }
        else {
            return true;
        }
    }

    /***
     * Détermine si le set est fini ou non
     * @return true s'il est terminé
     */
    public boolean endSet(){
        if (gamesInCurrentSetForPlayer(player1) >= 6 && ( gamesInCurrentSetForPlayer(player1)-gamesInCurrentSetForPlayer(player2) >=2 )){
            return true;
        }
        if (gamesInCurrentSetForPlayer(player2) >= 6 && ( gamesInCurrentSetForPlayer(player2)-gamesInCurrentSetForPlayer(player1) >=2 )){
            return true;
        }
        return false;
    }

    /***
     * Détermine si le joueur 1 a assez de set gagnés
     * @return true si oui, false sinon
     */
    public boolean IsPlayer1Winner(){
        int nbWinPlayer1 = 0 ;
        for (HashMap.Entry<Integer, PointsSet> entry : scoreJeuPlayer1.entrySet()){
            if (Integer.parseInt(entry.getValue().getScore()) >= Integer.parseInt(scoreJeuPlayer1.get(entry.getKey()).getScore()) -2 && Integer.parseInt(entry.getValue().getScore()) >= 6){
                nbWinPlayer1++;
            }
        }
        if(nbWinPlayer1 == matchType.numberOfSetsToWin()){
            return true;
        }
        else {
            return false;
        }
    }

    /***
     * Détermine si le joueur 2 a assez de set gagnés
     * @return true si oui, false sinon
     */
    public boolean IsPlayer2Winner(){
        int nbWinPlayer2 = 0 ;
        for (HashMap.Entry<Integer, PointsSet> entry : scoreJeuPlayer2.entrySet()){
            if (Integer.parseInt(entry.getValue().getScore()) >= Integer.parseInt(scoreJeuPlayer2.get(entry.getKey()).getScore()) -2 && Integer.parseInt(entry.getValue().getScore()) >= 6){
                nbWinPlayer2++;
            }
        }
        if(nbWinPlayer2 == matchType.numberOfSetsToWin()){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean endMatch(){
        if (IsPlayer1Winner()){
            return true;
        }
        if (IsPlayer2Winner()){
            return true;
        }
        return false;
    }

    /***
     * Création du nouveau set
     * @author Adeline Dumas
     */
    public void NewSet(){
        scoreJeuPlayer1.put(scoreJeuPlayer1.size() + 1, new PointsSet("0"));
        scoreJeuPlayer2.put(scoreJeuPlayer2.size() + 1, new PointsSet("0"));

    }

    //endregion
}
