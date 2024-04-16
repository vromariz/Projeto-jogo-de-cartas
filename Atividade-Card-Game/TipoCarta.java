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

    /*
     * public static <Raridade> TipoCarta dropAleatorio() {
     * double sorteio = new Random().nextDouble();
     * double acumulado = 0.0;
     * 
     * for (TipoCarta raridade : values()) {
     * acumulado += raridade.getProbabilidade();
     * if (sorteio < acumulado) {
     * return raridade;
     * }
     * }
     * 
     * return EPICO;
     * 
     * }
     */
}
