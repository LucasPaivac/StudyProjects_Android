package cedroart.lucas.jogodavelha;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 06/11/2017.
 */

class Games {
    private List<Game> games = new ArrayList<>();

    public Games(Game...games) {
        for(Game g : games)
            this.games.add(g);
    }
    public Game gamesAddSerie(int jogador){
        Game g;
        for(Game game : games){
            g = game.addSerie(jogador);
            if(g != null) return g;
        }
        return null;
    }
}
