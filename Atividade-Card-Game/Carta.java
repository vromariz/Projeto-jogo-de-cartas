public class Carta implements Ativacoes{
    private String nome;
    private String imagem;
    private String tipo;
    private TipoCarta raridade;
    // precisa ser TipoCarta. "e a raridadde da carta para sair direito"
    private int ataque;
    private int defesa;
    private int custo;
    private TipoHabilidade habilidade;
    private int quantidade;
    // ele não deve exceder 3 exceto manas


    public Carta(String nome, String imagem, String tipo, TipoCarta raridade, int ataque, int defesa, int custo,
            TipoHabilidade habilidade, int quantidade) {
        this.nome = nome;
        this.imagem = imagem;
        this.tipo = tipo;
        this.raridade = raridade;
        this.ataque = ataque;
        this.defesa = defesa;
        this.custo = custo;
        this.habilidade = habilidade;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TipoCarta getRaridade() {
        return raridade;
    }

    public void setRaridade(TipoCarta raridade) {
        this.raridade = raridade;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public TipoHabilidade getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(TipoHabilidade habilidade) {
        this.habilidade = habilidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (tipo.equals("mana")) {
            this.quantidade = quantidade;
        } else {
            this.quantidade = Math.min(quantidade, 3);
        }
        //se n for mana e usado math.min que limita o numero para 3
    }

    public void setUnique(boolean b) {
    }//quem usa isso e o loja e so um boolean falando se e verdadeiro ou falso

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
