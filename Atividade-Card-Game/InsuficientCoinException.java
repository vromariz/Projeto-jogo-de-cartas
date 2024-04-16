public class InsuficientCoinException extends Exception{
    public InsuficientCoinException(String message) {
        super(message);
        /*Trata o erro de quando o usuário quer comprar um booster e não possui saldo
para isto. */
    }
}
