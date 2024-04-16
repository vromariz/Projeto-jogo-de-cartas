import java.util.Random;

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