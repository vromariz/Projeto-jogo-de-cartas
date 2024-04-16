import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Arena {

    // public Arena(String nome, String imagem, String tipo, TipoCarta raridade, int
    // ataque, int defesa, int custo,
    // String habilidade, int quantidade) {
    // super(nome, imagem, tipo, raridade, ataque, defesa, custo, habilidade,
    // quantidade);

    // }

    // private Player player;
    // private int life1 = 20;
    // private int life2 = 20;
    // private Carta[][] campodecartas1;
    // private Carta[][] campodecartas2;
    // private Carta[] mao;
    // private int manaMaxima = 0;
    // private Carta[] cemiterio1;
    // private Carta[] cemiterio2;
    // private List<Carta> deck;
    // private Random random = new Random();

    // /*
    // * * Inicialmente a classe deve conter os dois jogadores, o deck escolhido
    // pelos
    // * * dois, dois campos de * cartas(se trata de duas matrizes 2x5 do tipo da
    // * classe carta) e 20 pontos de * vida para cada jogador. A * arena finaliza
    // * quando os pontos de vida de um dos jogadores zerar.
    // */

    // public Arena(String nome, String imagem, String tipo, TipoCarta raridade, int
    // ataque, int defesa, int custo,
    // String habilidade, int quantidade, int life1, int life2, Carta[][]
    // campodecartas1,
    // Carta[][] campodecartas2, Carta[] mao, int manaMaxima,
    // Carta[] cemiterio1, Carta[] cemiterio2, List<Carta> deck, Random random) {
    // super(nome, imagem, tipo, raridade, ataque, defesa, custo, habilidade,
    // quantidade);
    // this.life1 = life1;
    // this.life2 = life2;
    // this.campodecartas1 = campodecartas1;
    // this.campodecartas2 = campodecartas2;
    // this.mao = mao;
    // this.manaMaxima = manaMaxima;
    // this.cemiterio1 = cemiterio1;
    // this.cemiterio2 = cemiterio2;
    // this.deck = deck;
    // this.random = random;
    // }

    // public int getLife1() {
    // return life1;
    // }

    // public void setLife1(int life1) {
    // this.life1 = life1;
    // }

    // public int getLife2() {
    // return life2;
    // }

    // public void setLife2(int life2) {
    // this.life2 = life2;
    // }

    // public Carta[][] getCampodecartas1() {
    // return campodecartas1;
    // }

    // public void setCampodecartas1(Carta[][] campodecartas1) {
    // this.campodecartas1 = campodecartas1;
    // }

    // public Carta[][] getCampodecartas2() {
    // return campodecartas2;
    // }

    // public void setCampodecartas2(Carta[][] campodecartas2) {
    // this.campodecartas2 = campodecartas2;
    // }

    // /*
    // * para definir quando algum jogador ganhar, podemos tambem implmentar * um
    // * while para sempre rodar a arena enquanto o jogo estiver rodando
    // */ public boolean jogorodando() {
    // while (true) {
    // if (life1 == 0) {
    // System.out.println("jogador 2 ganhou");
    // return false;
    // } else if (life2 == 0) {
    // System.out.println("jogador 1 ganhou");
    // return false;
    // } else {
    // return true;
    // }
    // }

    // }

    // public void verificarMorteDosJogadores() {
    // while (life1 > 0 || life2 > 0) {
    // if (life1 <= 0) {
    // System.out.println("Jogador 1 morreu!");
    // }
    // if (life2 <= 0) {
    // System.out.println("Jogador 2 morreu!");
    // }

    // }
    // }

    //
    //
    // public void fimDoTurno(Player adversario){
    // if (vida < 1) {
    // System.out.println("Player " + (adversario == this ? 2 : 1) + " é o
    // vencedor!");
    // if (adversario == this) {
    // cardCoins += 100;
    // } else {
    // adversario.cardCoins += 100;
    // }
    // }
    // }

    // public void compra() {
    // if (deck.size() > 0) {
    // // Compra uma carta aleatória do deck
    // Collections.shuffle(deck);
    // for (int i = 0; i < mao.length; i++) {
    // if (mao[i] == null) {
    // mao[i] = deck.get(0);
    // deck.remove(0);
    // break;
    // }
    // }
    // // Renova a mana máxima
    // manaMaxima++;
    // }
    // }

    // public void posicionamento() {
    // if (manaMaxima > 0) {
    // // Posiciona uma mana
    // manaMaxima--;
    // } else {
    // // Posiciona uma carta no campo (segunda linha do vetor do campo)
    // // Reduz o valor correspondente da mana (implementação não fornecida)
    // }
    // }

    // public <Player> void ataque(Player adversario) {
    // for (int i = 0; i < mao.length; i++) {
    // if (mao[i] != null && adversario.vida > 0) {
    // int dano = mao[i].getDano(); // Supõe que Carta tem um método getDano() para
    // obter o dano da carta.
    // adversario.vida -= dano;
    // if (adversario.vida < 1) {
    // // Mover a carta do campo para o cemitério
    // cemiterio2[i] = mao[i];
    // mao[i] = null;
    // adversario.vida = 0;
    // }
    // }
    // }
    // }

    // public void fimDoTurno(Player adversario) {
    // if (vida < 1) {
    // System.out.println("Player " + (adversario == this ? 2 : 1) + " é o
    // vencedor!");
    // if (adversario == this) {
    // cardCoins += 100;
    // } else {
    // adversario.cardCoins += 100;
    // }
    // }
    // }
    // }

    private Player player1;
    private Player player2;
    private Deck playerDeck1;
    private Deck playerDeck2;
    private Carta[][] campo_player1 = new Carta[2][5];
    private Carta[][] campo_player2 = new Carta[2][5];;
    private int life_player1 = 20;
    private int life_player2 = 20;
    private int mao_player1[] = new int[10];
    private int mao_player2[] = new int[10];
    private int mana_Maxima1 = 0;
    private int mana_Maxima2 = 0;
    private Carta[] cemiterio_Player1;
    private Carta[] cemiterio_Player2;
    private boolean gamerodando = false;
    private Random random = new Random();

    public Arena(Player player1, Player player2, Deck playerDeck1, Deck playerDeck2, Carta[][] campo_player1,
            Carta[][] campo_player2, int life_player1, int life_player2, int[] mao_player1, int[] mao_player2,
            int mana_Maxima, Carta[] cemiterio_Player1, Carta[] cemiterio_Player2, boolean gamerodando) {
        this.player1 = player1;
        this.player2 = player2;
        this.playerDeck1 = playerDeck1;
        this.playerDeck2 = playerDeck2;
        this.campo_player1 = campo_player1;
        this.campo_player2 = campo_player2;
        this.life_player1 = life_player1;
        this.life_player2 = life_player2;
        this.mao_player1 = mao_player1;
        this.mao_player2 = mao_player2;
        this.mana_Maxima1 = mana_Maxima1;
        this.mana_Maxima2 = mana_Maxima2;
        this.cemiterio_Player1 = cemiterio_Player1;
        this.cemiterio_Player2 = cemiterio_Player2;
        this.gamerodando = gamerodando;
    }

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

    public Deck getPlayerDeck1() {
        return playerDeck1;
    }

    public void setPlayerDeck1(Deck playerDeck1) {
        this.playerDeck1 = playerDeck1;
    }

    public Deck getPlayerDeck2() {
        return playerDeck2;
    }

    public void setPlayerDeck2(Deck playerDeck2) {
        this.playerDeck2 = playerDeck2;
    }

    public Carta[][] getCampo_player1() {
        return campo_player1;
    }

    public void setCampo_player1(Carta[][] campo_player1) {
        this.campo_player1 = campo_player1;
    }

    public Carta[][] getCampo_player2() {
        return campo_player2;
    }

    public void setCampo_player2(Carta[][] campo_player2) {
        this.campo_player2 = campo_player2;
    }

    public int getLife_player1() {
        return life_player1;
    }

    public void setLife_player1(int life_player1) {
        this.life_player1 = life_player1;
    }

    public int getLife_player2() {
        return life_player2;
    }

    public void setLife_player2(int life_player2) {
        this.life_player2 = life_player2;
    }

    public int[] getmao_player1() {
        return mao_player1;
    }

    public void setmao_player1(int[] mao_player1) {
        this.mao_player1 = mao_player1;
    }

    public int[] getmao_player2() {
        return mao_player2;
    }

    public void setmao_player2(int[] mao_player2) {
        this.mao_player2 = mao_player2;
    }

    public int getMana_Maxima1() {
        return mana_Maxima1;
    }

    public void setMana_Maxima1(int mana_Maxima) {
        this.mana_Maxima1 = mana_Maxima;
    }

    public int getMana_Maxima2() {
        return mana_Maxima2;
    }

    public void setMana_Maxima2(int mana_Maxima) {
        this.mana_Maxima2 = mana_Maxima;
    }

    public Carta[] getCemiterio_Player1() {
        return cemiterio_Player1;
    }

    public void setCemiterio_Player1(Carta[] cemiterio_Player1) {
        this.cemiterio_Player1 = cemiterio_Player1;
    }

    public Carta[] getCemiterio_Player2() {
        return cemiterio_Player2;
    }

    public void setCemiterio_Player2(Carta[] cemiterio_Player2) {
        this.cemiterio_Player2 = cemiterio_Player2;
    }

    public void turno() {
        inicio();
        compra();
        posicionamento();
        ataque(null);
    }

    public void saque() {
        // Seleciona 7 cartas aleatórias do deck
        Collections.shuffle(playerDeck1);
        for (int i = 0; i < 7; i++) {
            if (i < mao_player1.length) {
                mao_player1[i] = playerDeck1.get(i);
            }
        }

        Collections.shuffle(playerDeck2);
        for (int i = 0; i < 7; i++) {
            if (i < mao_player2.length) {
                mao_player2[i] = playerDeck2.get(i);
            }
        }
    }

    public void retornoDeCartasplayer1() {
        // O jogador escolhe até 5 cartas para retornar ao deck
        for (int i = 0; i < 5; i++) {
            if (mao_player1 != null) {
                playerDeck1.add(mao_player1[i]);
                mao_player1[i] = null;
            }
            saque();
        }
    }

    public void retornoDeCartasplaye2() {
        for (int i = 0; i < 5; i++) {
            if (mao_player2 != null) {
                playerDeck2.add(mao_player2[i]);
                mao_player2[i] = null;
            }
        }
        saque(); // Recebe o mesmo número de cartas de volta
    }

    public void compraplayer1() {
        if (playerDeck1.size() > 0) {
            // Compra uma carta aleatória do deck
            Collections.shuffle(playerDeck1);
            for (int i = 0; i < mao.length; i++) {
                if (mao_player1[i] == 0) {
                    mao_player1[i] = deck.get(0);
                    deck.remove(0);
                    break;
                }
            }
            mana_Maxima1++;
        }

    }

    public void compraplayer2() {
        if (playerDeck2.size() > 0) {
            // Compra uma carta aleatória do deck
            Collections.shuffle(playerDeck2);
            for (int i = 0; i < mao.length; i++) {
                if (mao_player2[i] == 0) {
                    mao_player2[i] = deck.get(0);
                    deck.remove(0);
                    break;
                }
            }
            mana_Maxima2++;
        }
    }

    public void inicio() {
        int sorteio = random.nextInt(2);

        if (sorteio = 1) {
            System.out.println("player1 começa");
        } else if (sorteio = 2) {
            System.out.println("player2 comeca");
        }
    }

    private void posicionamento1(Player player1) {
        Carta[] maoPlayer1 = player1.getmao_player1(); // Supondo que a classe Player tenha um método getMao()

        if (player1.getMana_Maxima1() > 0) {
            for (int i = 0; i < maoPlayer1.length; i++) {
                if (maoPlayer1[i] != null) {
                    if (maoPlayer1[i] instanceof Mana) {
                        // Posiciona a mana no campo
                        for (int j = 0; j < campo_player1[0].length; j++) {
                            if (campo_player1[0][j] == null) {
                                campo_player1[0][j] = maoPlayer1[i];
                                player1.decrementarManaMaxima(); // Reduz a mana máxima
                                maoPlayer1[i] = null;
                                break;
                            }
                        }
                    } else {
                        // Posiciona a carta no campo (na segunda linha)
                        for (int j = 0; j < campo_player1[1].length; j++) {
                            if (campo_player1[1][j] == null) {
                                campo_player1[1][j] = maoPlayer1[i];
                                maoPlayer1[i] = null;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private void posicionamento2(Player player2) {
        Carta[] maoPlayer2 = player2.getmao_player2(); // Supondo que a classe Player tenha um método getMao()

        if (player2.getMana_Maxima2() > 0) {
            for (int i = 0; i < maoPlayer2.length; i++) {
                if (maoPlayer2[i] != null) {
                    if (maoPlayer2[i] instanceof Mana) {
                        // Posiciona a mana no campo
                        for (int j = 0; j < campo_player2[0].length; j++) {
                            if (campo_player2[0][j] == null) {
                                campo_player2[0][j] = maoPlayer2[i];
                                player2.decrementarManaMaxima(); // Reduz a mana máxima
                                maoPlayer2[i] = null;
                                break;
                            }
                        }
                    } else {
                        // Posiciona a carta no campo (na segunda linha)
                        for (int j = 0; j < campo_player2[1].length; j++) {
                            if (campo_player2[1][j] == null) {
                                campo_player2[1][j] = maoPlayer2[i];
                                maoPlayer2[i] = null;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void ataque(Player jogadorAtacante, Player jogadorAlvo) { // o método de ataque que recebe dois jogadores
                                                                     // como parâmetros
        Carta[][] campoAtacante = (jogadorAtacante.equals(player1)) ? campo_player1 : campo_player2; // o jogador que
                                                                                                     // vai atacar
        Carta[][] campoAlvo = (jogadorAlvo.equals(player1)) ? campo_player1 : campo_player2; // o jogador que será
                                                                                             // atacado

        for (int i = 0; i < campoAtacante.length; i++) { // loop que percorre as linhas do campo do jogador atacante
            for (int j = 0; j < campoAtacante[i].length; j++) { // loop que percorre as colunas do campo do jogador
                                                                // atacante
                if (campoAtacante[i][j] != null && campoAtacante[i][j] instanceof Criatura) {
                    Criatura criaturaAtacante = (Criatura) campoAtacante[i][j];

                    for (int k = 0; k < campoAlvo.length; k++) {
                        for (int l = 0; l < campoAlvo[k].length; l++) { // percorrem as posições do campo do jogador
                                                                        // alvo
                            if (campoAlvo[k][l] != null && campoAlvo[k][l] instanceof Criatura) {
                                Criatura criaturaAlvo = (Criatura) campoAlvo[k][l];

                                criaturaAlvo.decrementarVida(criaturaAtacante.getAtaque());
                            }
                        }
                    }
                }
            }
        }
    }

    public void verificarVitoria(Player jogador) {
        if (jogador.equals(player1)) {
            if (life_player2 <= 0) {
                System.out.println("Player 1 é o vencedor!");
                progresso();
            } else if (life_player1 <= 0) {
                System.out.println("Player 1 perdeu!");
            }
        } else if (jogador.equals(player2)) {
            if (life_player1 <= 0) {
                System.out.println("Player 2 é o vencedor!");
                progresso();
            } else if (life_player2 <= 0) {
                System.out.println("Player 2 perdeu!");
            }
        }
    }
}
