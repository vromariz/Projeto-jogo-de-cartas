import java.util.Random;

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
