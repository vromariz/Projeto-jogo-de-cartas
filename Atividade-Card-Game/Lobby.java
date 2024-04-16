import java.util.concurrent.TimeUnit;

public class Lobby {
    private Usuario player;
    private String gameMode;
    private Usuario opponent;

    public Lobby(Usuario player) {
        this.player = player;
        this.gameMode = "Normal Game";
        this.opponent = null;
    }

    public void setPlayer(Usuario player) {
        this.player = player;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public void setOpponent(Usuario opponent) {
        this.opponent = opponent;
    }

    public Usuario getPlayer() {
        return player;
    }

    public String getGameMode() {
        return gameMode;
    }

    public Usuario getOpponent() {
        return opponent;
    }

    // public void chooseDeck(Deck deck) {
    // }

    public void chooseGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public void findOpponent() {
        try {
            long startTime = System.currentTimeMillis(); 
    
            while (true) {
                if (opponent.getNivel() == player.getNivel()) {
                    startGame();
                    break; 
                }

                long currentTime = System.currentTimeMillis();
                long backTime = currentTime - startTime;
                if (backTime > TimeUnit.MINUTES.toMillis(3)) {
                    throw new TimeOutException("Demorou mais de 3 minutos para encontrar um oponente");
                }
            }
        } catch (TimeOutException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    
    }

    public void startGame() {

    }
}
