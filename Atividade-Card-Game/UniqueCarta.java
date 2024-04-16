import java.util.Random;

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