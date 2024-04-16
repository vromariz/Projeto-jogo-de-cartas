import java.util.Random;

public class Loja {
    private boolean promocao;
    private String numeroDoCartao;
    private String codigoVerificador;

    public Loja(boolean promocao, String numeroDoCartao, String codigoVerificador) {
        this.promocao = promocao;
        this.numeroDoCartao = numeroDoCartao;
        this.codigoVerificador = codigoVerificador;
    }

    public String getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public void setNumeroDoCartao(String numeroDoCartao) {
        this.numeroDoCartao = numeroDoCartao;
    }

    public String getCodigoVerificador() {
        return codigoVerificador;
    }

    public void setCodigoVerificador(String codigoVerificador) {
        this.codigoVerificador = codigoVerificador;
    }

    public boolean getPromocao() {
        return promocao;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;

    }

    public Loja(boolean promocao) {
        this.promocao = promocao;
    }

    public void comprarBooster(Usuario usuario) {
        if (promocao) {
            int preco = 15; // já que fica 50% mais caro na promo
            usuario.decrementarCardCoins(preco);
        } else {
            int preco = 10; // preço original
            usuario.decrementarCardCoins(preco);
        }

        Carta carta = gerarCartaAleatoria();
        Usuario.getInventario().adicionarCarta(carta);
    }

    public void comprarBoosterEspecial(Usuario usuario) {
        int preco;
        if (promocao) {
            preco = 15; // msm lógica de antes
        } else {
            preco = 10;
        }

        usuario.decrementarCardCoins(preco);

        Carta carta = gerarCartaAleatoria();
        if (probabilidadeCartaUnica()) {
            carta.setUnique(true);
        }
        Usuario.getInventario().adicionarCarta(carta);
    }

    public Carta gerarCartaAleatoria() {
        Random random = new Random();
        TipoCarta[] tipoCartas = { TipoCarta.COMUM, TipoCarta.EPICO, TipoCarta.INCOMUM, TipoCarta.MUITO_RARO,
                TipoCarta.RARO }; // mudar para nome das cartas
        int indiceAleatorioTipoCartas = random.nextInt(tipoCartas.length);

        String[] nomes = { "Carta X", "Carta Y", "Carta Z" };
        int indiceAleatorioNome = random.nextInt(nomes.length);

        // int valorAleatorio = random.nextInt(10) + 1;

        return new Carta(nomes[indiceAleatorioNome], null, null, tipoCartas[indiceAleatorioTipoCartas], 0, 0, 0, null,
                0);
    }

    public boolean probabilidadeCartaUnica() {
        Random random = new Random();
        int chance = random.nextInt(100);

        if (chance < 1) {
            return true;
        } else {
            return false;
        }

        /*
         * Inicialmente vamos permitir
         * que o usuário compre booster apenas com cardcoins, um booster tem 12 cartas
         * aleatórias que serão
         * adicionadas no inventário do usuário, caso o usuário ele receba uma carta
         * onde já possui 3 unidades ele
         * receberá um valor em cardcoins ao invés da carta.
         */

    }

    public void compra() {
        try {
            if (usuario.getCardCoins() >= preco) {
                usuario.decrementarCardCoins(preco);
            } else {
                throw new InsuficientCoinException("Saldo insuficiente para comprar o booster.");
            }
            comprarBooster(true);
        } catch (InsuficientCoinException e) {
            System.err.println("Erro: " + e.getMessage());

        }
    }
}