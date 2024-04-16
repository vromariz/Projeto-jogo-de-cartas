import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ArenaDupla extends Arena {

    /*
     * • A classe irá herdar da arena e vai ter dois players a mais.
     * • Sobrescrito – O método de saque e início deverá ser sobre escrito para 4
     * players.
     * • Os pontos de vida não são alterados, ou seja, os pontos de vida são
     * compartilhados.
     * • Sobre carregado – O método turno será sobrecarregado com outro
     * player(aliado) irá receber um vetor
     * aliado que vai ser concatenado ao seu vetor de ataque e o vetor inimigo será
     * o vetor com as criaturas
     * dos outros dois inimigos.
     */

     private Player aliadoPlayer1;
     private Player aliadoPlayer2;
 
     public ArenaDupla(Player player1, Player player2, Player aliadoPlayer1, Player aliadoPlayer2,
                       Deck playerDeck1, Deck playerDeck2, Deck aliadoDeck1, Deck aliadoDeck2,
                       Carta[][] campo_player1, Carta[][] campo_player2,
                       int[] mao_player1, int[] mao_player2,
                       int[] aliadoMao_player1, int[] aliadoMao_player2,
                       int mana_Maxima, Carta[] cemiterio_Player1, Carta[] cemiterio_Player2) {
         super(player1, player2, playerDeck1, playerDeck2, campo_player1, campo_player2,
               mao_player1, mao_player2, mana_Maxima, cemiterio_Player1, cemiterio_Player2);
 
         this.aliadoPlayer1 = aliadoPlayer1;
         this.aliadoPlayer2 = aliadoPlayer2;
 
         aliadoPlayer1.setDeck(aliadoDeck1);
         aliadoPlayer2.setDeck(aliadoDeck2);
     }
 
     @Override
     public void Saque() {
         super.Saque();
 
         List<Carta> aliadoDeck1 = aliadoPlayer1.getDeck().getCartas();
         List<Carta> aliadoDeck2 = aliadoPlayer2.getDeck().getCartas();
 
         Collections.shuffle(aliadoDeck1);
         Collections.shuffle(aliadoDeck2);
 
         for (int i = 0; i < 7; i++) {
             if (i < aliadoMao_player1.length) {
                 aliadoMao_player1[i] = aliadoDeck1.get(i).getId();
             }
             if (i < aliadoMao_player2.length) {
                 aliadoMao_player2[i] = aliadoDeck2.get(i).getId();
             }
         }
     }
 
     @Override
     public void inicio() {
         Random random = new Random();
         int startingPlayer = random.nextInt(4) + 1;
 
         System.out.println("Player " + startingPlayer + " começa!");
     }
 
     @Override
     public void turno(Player jogadorAtual, Player adversario) {
         super.turno(jogadorAtual, adversario);
 
         fimDoTurno(jogadorAtual, adversario);
     }
 
     public void turno(Player jogadorAtual, Player adversario, Player aliado, Carta[] aliadoMao) {
         int[] novoAtaque = Arrays.copyOf(jogadorAtual.getAtaque(), jogadorAtual.getAtaque().length + aliado.getAtaque().length);
         System.arraycopy(aliado.getAtaque(), 0, novoAtaque, jogadorAtual.getAtaque().length, aliado.getAtaque().length);
         jogadorAtual.setAtaque(novoAtaque);
 
         int[] novaMao = Arrays.copyOf(jogadorAtual.getMao(), jogadorAtual.getMao().length + aliadoMao.length);
         System.arraycopy(aliadoMao, 0, novaMao, jogadorAtual.getMao().length, aliadoMao.length);
         jogadorAtual.setMao(novaMao);
 
         int[] vetorInimigo = adversario.getAtaque().clone();
         int[] aliadoInimigo = aliado.getAtaque().clone();
 
         super.turno(jogadorAtual, vetorInimigo);
 
         aliado.setAtaque(aliadoInimigo);
     }
 
     public void aliadoAtaque(Player jogadorAtual, Player aliado, Player adversario) {
         int[] aliadoAtaque = aliado.getAtaque();
         for (int i = 0; i < aliadoAtaque.length; i++) {
             if (aliadoAtaque[i] > 0) {
                 adversario.setVida(adversario.getVida() - aliadoAtaque[i]);
             }
         }
     }
}