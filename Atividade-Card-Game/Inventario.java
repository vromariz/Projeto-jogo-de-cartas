public class Inventario {
    private Deck[] cartas;
    private int nivelAtual;
    private int quantidadeDeCardcoins;

    public Inventario(int nivelAtual, int quantidadeDeCardcoins, Deck[] decks) {
        this.cartas = new Deck[200];
        this.nivelAtual = nivelAtual;
        this.quantidadeDeCardcoins = quantidadeDeCardcoins;
    }

    public Deck[] getCartas() {
        return cartas;
    }

    public void setCartas(Deck[] cartas) {
        this.cartas = cartas;
    }

    public int getNivelAtual() {
        return nivelAtual;
    }

    public void setNivelAtual(int nivelAtual) {
        this.nivelAtual = nivelAtual;
    }

    public double getQuantidadeDeCardcoins() {
        return quantidadeDeCardcoins;
    }

    public void setQuantidadeDeCardcoins(int quantidadeDeCardcoins) {
        this.quantidadeDeCardcoins = quantidadeDeCardcoins;
    }
 
    //adicionar no futuro
    public void removerCarta(Carta carta) {
    }

    public void adicionarCarta(Carta carta) {
    }
}