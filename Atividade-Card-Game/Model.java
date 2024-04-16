public class Model {

    public class ArenaDupla{
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
    public class ArenaDupla {

    private Player aliadoPlayer1;
    private Player aliadoPlayer2;

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
    public class Carta{
    public void ativacao(){
        if (tipoHabilidade == TipoHabilidade.FEAR ||
        tipoHabilidade == TipoHabilidade.CHARM ||
        tipoHabilidade == TipoHabilidade.FROZEN ||
        tipoHabilidade == TipoHabilidade.CALL ||
        tipoHabilidade == TipoHabilidade.EXECUTE ||
        tipoHabilidade == TipoHabilidade.SLEEP) {
            this.setAtaque(this.getAtaque() * 2);
        }

}
}
public class Deck{
    // Adiciona uma carta ao deck e remove do inventário
    public void adicionarCarta(Carta carta, Inventario inventario) {
        if (!disponibilidade && cartas.size() < 60) {
            // Verifica se o deck ainda não está disponível e possui menos de 50 cartas
            cartas.add(carta);
            inventario.removerCarta(carta);
            atualizarDisponibilidade();
        }
    }

    // Remove uma carta do deck e a adiciona ao inventário
    public void removerCarta(Carta carta, Inventario inventario) {
        if (cartas.contains(carta)) {
            cartas.remove(carta);
            inventario.adicionarCarta(carta);
            atualizarDisponibilidade();
        }
    }

    // Verifica as condições para atualizar a disponibilidade do deck
    public void atualizarDisponibilidade() {
        int quantidadeMinima = 60;
        int quantidadeMaximaRepetida = 3;
        int totalCartas = cartas.size();
        int maxRepeticoes = 0;

        try {

            for (int i = 0; i < totalCartas; i++) {
                Carta carta = cartas.get(i);
                int repeticoes = 1;

                for (int j = i + 1; j < totalCartas; j++) {
                    if (carta.equals(cartas.get(j))) {
                        repeticoes++;
                    }
                }
                if (repeticoes > maxRepeticoes) {
                    maxRepeticoes = repeticoes;
                }
            }

            if (totalCartas >= quantidadeMinima && maxRepeticoes <= quantidadeMaximaRepetida) {
                disponibilidade = true;
            } else {
                disponibilidade = false;
                throw new IrregularDeckException("O deck é irregular verifique as condições");
            }

            atualizarDisponibilidade();
        } catch (IrregularDeckException e) {
            System.err.println("Erro: " + e.getMessage());

        }

    }
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
    public enum TipoCarta {
        COMUM(0.8),
        INCOMUM(0.15),
        RARO(0.04),
        MUITO_RARO(0.008),
        EPICO(0.02);
    
        private double dropProbabilidade;
    
        private TipoCarta(double dropProbabilidade) {
            this.dropProbabilidade = dropProbabilidade;
        }
    
        public double getDropProbabilidade() {
            return dropProbabilidade;
        }
    
        public void setDropProbabilidade(double dropProbabilidade) {
            this.dropProbabilidade = dropProbabilidade;
        }
    
}
public enum TipoHabilidade {
    FEAR,
    CHARM,
    FROZEN,
    CALL,
    EXECUTE,
    SLEEP;
}

public class PasseComum extends Progresso {

    public PasseComum(Progresso.Premiacao[] vetorPremiacoes, int premiacaoAtual) {
        super(vetorPremiacoes, premiacaoAtual);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void entrgarPremiacao() {
        if (premiacaoAtual < vetorPremiacoes.length) {
            Carta carta = gerarCartaAleatoria();
            Usuario.getInventario().adicionarCarta(carta);
            premiacaoAtual++;
        } else {
            System.out.println("Passe chegou ao fim. Não é possível ganhar mais premiações.");
        }
    
    }


    @Override
    public void comprarBooster(Usuario usuario) {
        Carta carta = gerarCartaAleatoria();
        Usuario.getInventario().adicionarCarta(carta);
    }
    
    @Override
    public Carta gerarCartaAleatoria() {
        Random random = new Random();
        TipoCarta[] tipoCartas = {TipoCarta.COMUM, TipoCarta.EPICO, TipoCarta.INCOMUM, TipoCarta.MUITO_RARO, TipoCarta.RARO}; // mudar para nome das cartas 
        int indiceAleatorioTipoCartas = random.nextInt(tipoCartas.length);

        String[] nomes = {"Carta X", "Carta Y", "Carta Z"};
        int indiceAleatorioNome = random.nextInt(nomes.length);

        return new Carta(nomes[indiceAleatorioNome], null, null, tipoCartas[indiceAleatorioTipoCartas], 0, 0, 0, null, 0);
    }

    @Override
    public void progresso() {
        System.out.println("Ganhou uma vitória! Avançando um nível no passe de batalha.");
        premiacaoAtual++;
    }

}
public class PassePremium extends Progresso {

    public PassePremium(Progresso.Premiacao[] vetorPremiacoes, int premiacaoAtual) {
        super(vetorPremiacoes, premiacaoAtual);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void entrgarPremiacao() {
        if (premiacaoAtual < vetorPremiacoes.length) {
            premiacaoAtual++;
        } else {
            System.out.println("Passe chegou ao fim. Zerando e reiniciando as premiações.");
            premiacaoAtual = 0;
        }
    }

    @Override
    public void progresso() {
        
        premiacaoAtual += 2; // Avança dois níveis por vitória

        if (premiacaoAtual % 5 == 0) {
            Carta carta = gerarCartaAleatoria();
        if (probabilidadeCartaUnica()) {
            carta.setUnique(true);
        }
        Usuario.getInventario().adicionarCarta(carta);
        } else {
            Carta carta = gerarCartaAleatoria();
            Usuario.getInventario().adicionarCarta(carta);
        }
    }
    
    @Override
    public Carta gerarCartaAleatoria() {
        Random random = new Random();
        TipoCarta[] tipoCartas = {TipoCarta.COMUM, TipoCarta.EPICO, TipoCarta.INCOMUM, TipoCarta.MUITO_RARO, TipoCarta.RARO}; // mudar para nome das cartas 
        int indiceAleatorioTipoCartas = random.nextInt(tipoCartas.length);

        String[] nomes = {"Carta X", "Carta Y", "Carta Z"};
        int indiceAleatorioNome = random.nextInt(nomes.length);

        return new Carta(nomes[indiceAleatorioNome], null, null, tipoCartas[indiceAleatorioTipoCartas], 0, 0, 0, null, 0);
    }

    @Override
    public boolean probabilidadeCartaUnica() {
        Random random = new Random();
        int chance = random.nextInt(100);

        if (chance < 1) {
            return true;
        } else {
            return false;
        }
}
}
public class Player {
    
}
public abstract class Progresso {

    public enum Premiacao {
        PREMIACAO_1,
        PREMIACAO_2,
        PREMIACAO_3,
        PREMIACAO_4,
        PREMIACAO_5,
        PREMIACAO_6,
        PREMIACAO_7,
        PREMIACAO_8,
        PREMIACAO_9,
        PREMIACAO_10,
        PREMIACAO_11,
        PREMIACAO_12,
        PREMIACAO_13,
        PREMIACAO_14,
        PREMIACAO_15,
        PREMIACAO_16,
        PREMIACAO_17,
        PREMIACAO_18,
        PREMIACAO_19,
        PREMIACAO_20,
        PREMIACAO_21,
        PREMIACAO_22,
        PREMIACAO_23,
        PREMIACAO_24,
        PREMIACAO_25,
        PREMIACAO_26,
        PREMIACAO_27,
        PREMIACAO_28,
        PREMIACAO_29,
        PREMIACAO_30,
        PREMIACAO_31,
        PREMIACAO_32,
        PREMIACAO_33,
        PREMIACAO_34,
        PREMIACAO_35,
        PREMIACAO_36,
        PREMIACAO_37,
        PREMIACAO_38,
        PREMIACAO_39,
        PREMIACAO_40,
        PREMIACAO_41,
        PREMIACAO_42,
        PREMIACAO_43,
        PREMIACAO_44,
        PREMIACAO_45,
        PREMIACAO_46,
        PREMIACAO_47,
        PREMIACAO_48,
        PREMIACAO_49,
        PREMIACAO_50,
        PREMIACAO_51,
        PREMIACAO_52,
        PREMIACAO_53,
        PREMIACAO_54,
        PREMIACAO_55,
        PREMIACAO_56,
        PREMIACAO_57,
        PREMIACAO_58,
        PREMIACAO_59,
        PREMIACAO_60
    }

    protected Premiacao[] vetorPremiacoes;
    protected int premiacaoAtual;
    public Progresso(Progresso.Premiacao[] vetorPremiacoes, int premiacaoAtual) {
        this.vetorPremiacoes = vetorPremiacoes = new Premiacao[60];
        this.premiacaoAtual = premiacaoAtual;
    }
    public Premiacao[] getVetorPremiacoes() {
        return vetorPremiacoes;
    }
    public void setVetorPremiacoes(Premiacao[] vetorPremiacoes) {
        this.vetorPremiacoes = vetorPremiacoes;
    }
    public int getPremiacaoAtual() {
        return premiacaoAtual;
    }
    public void setPremiacaoAtual(int premiacaoAtual) {
        this.premiacaoAtual = premiacaoAtual;
    }
    
    public abstract void entrgarPremiacao();

    public abstract void progresso();
}
public class Player {
    
}
public class TimeOutException extends Exception{
    public TimeOutException(String message) {
        super(message);
        /*Trata o erro para players que estouraram o timer esperando por uma partida; */
    }
}
public enum TipoHabilidade {
    FEAR,
    CHARM,
    FROZEN,
    CALL,
    EXECUTE,
    SLEEP;
}
public class UniqueCarta extends Carta {

    public UniqueCarta(String nome, String imagem, String tipo, TipoCarta raridade, int ataque, int defesa, int custo,
            TipoHabilidade habilidade, int quantidade) {
        super(nome, imagem, tipo, raridade, ataque + 1, defesa + 1, custo, habilidade, quantidade);

        adicionarHabilidadeAleatoria();
    }

    public void adicionarHabilidadeAleatoria() {
        Random random = new Random();
        TipoHabilidade[] habilidades = TipoHabilidade.values();
        TipoHabilidade habilidadeAleatoria;

        do {
            habilidadeAleatoria = habilidades[random.nextInt(habilidades.length)];
        } while (habilidadeAleatoria == getHabilidade());

        setHabilidade(habilidadeAleatoria);
    }

    @Override
    public void ativacao(){
        if (tipoHabilidade == TipoHabilidade.FEAR ||
            tipoHabilidade == TipoHabilidade.CHARM ||
            tipoHabilidade == TipoHabilidade.FROZEN ||
            tipoHabilidade == TipoHabilidade.CALL ||
            tipoHabilidade == TipoHabilidade.EXECUTE ||
            tipoHabilidade == TipoHabilidade.SLEEP) {
                this.setAtaque(this.getAtaque() * 2);
            }
    }
}
}

