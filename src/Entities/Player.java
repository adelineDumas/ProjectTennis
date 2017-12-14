/***
 * Classe permettant de stocker un joueur
 * @Author : Adeline Dumas - 14/12/2017 - Création
 */
public class Player {

    //region variables

    private String name;

    //endregion

    //region constructeur

    public Player(String name) {
        this.name = name;
    }

    //endregion

    //region getter

    public String getName() {
        return name;
    }

    //endregion
}
