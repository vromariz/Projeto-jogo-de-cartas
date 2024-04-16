import java.util.ArrayList;

public class Deck {
    private String nome;
    private ArrayList<Carta> cartas;
    private boolean disponibilidade;

    public Deck(String nome) {
        this.nome = nome;
        this.cartas = new ArrayList<>();
        this.disponibilidade = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    /*
     * para que ele esteja disponivel ele deve ter as seguintes condições:
     * ter no mínimo 60 cartas e não possuir mais de 3 cartas
     * repetidas(Exceto mana), uma vez que essas condições são satisfeitas o
     * atributo passa a ser true e o deck pode ser usado em partida;
     * 
     * Quando uma carta entra no deck, esta carta deve ser subtraída do inventário,
     * ou seja, se o usuário
     * possui 3 determinadas cartas repetidas e ele coloca uma no deck, então o
     * inventário irá constar 2
     * cartas. De maneira análoga se ele remover a carta do deck ela deverá ser
     * incrementada no inventário
     * novamente.
     */
    public boolean isDisponivel() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

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
