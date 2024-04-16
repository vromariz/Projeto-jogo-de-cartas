public class TimeOutException extends Exception{
    public TimeOutException(String message) {
        super(message);
        /*Trata o erro para players que estouraram o timer esperando por uma partida; */
    }
}
