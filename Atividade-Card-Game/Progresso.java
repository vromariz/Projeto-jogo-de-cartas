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
