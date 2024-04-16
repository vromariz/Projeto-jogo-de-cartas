import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import javax.naming.InsufficientResourcesException;

public class Controller {

    private Arena arena;
    private ArenaDupla arenaDupla;
    private Ativacoes ativacoes;
    private Carta carta;
    private Deck deck;
    private InsufficientResourcesException insufficientResourcesException;
    private Invetario inventario;
    private IrregularDeckException irregularDeckException;
    private Lobby lobby;
    private Loja loja;
    private PasseComum passeComum;
    private PassePremuim passePremium;
    private Player player;
    private Progresso progresso;
    private TimeoutException timeoutException;
    private TipoCarta tipoCarta;
    private TipoHabilidade tipoHabilidade;
    private UniqueCarta uniqueCarta;
    private Usario usuario;
    private GameView gameView;

    public Controller(Arena arena, ArenaDupla arenaDupla, Ativacoes ativacoes, Carta carta, Deck deck,
            InsufficientResourcesException insufficientResourcesException, Invetario inventario,
            IrregularDeckException irregularDeckException, Lobby lobby, Loja loja, PasseComum passeComum,
            PassePremuim passePremium, Player player, Progresso progresso, TimeoutException timeoutException,
            TipoCarta tipoCarta, TipoHabilidade tipoHabilidade, UniqueCarta uniqueCarta, Usario usuario,
            GameView gameView) {
                
        this.arena = arena;
        this.arenaDupla = arenaDupla;
        this.ativacoes = ativacoes;
        this.carta = carta;
        this.deck = deck;
        this.insufficientResourcesException = insufficientResourcesException;
        this.inventario = inventario;
        this.irregularDeckException = irregularDeckException;
        this.lobby = lobby;
        this.loja = loja;
        this.passeComum = passeComum;
        this.passePremium = passePremium;
        this.player = player;
        this.progresso = progresso;
        this.timeoutException = timeoutException;
        this.tipoCarta = tipoCarta;
        this.tipoHabilidade = tipoHabilidade;
        this.uniqueCarta = uniqueCarta;
        this.usuario = usuario;
        this.gameView = gameView;
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public ArenaDupla getArenaDupla() {
        return arenaDupla;
    }

    public void setArenaDupla(ArenaDupla arenaDupla) {
        this.arenaDupla = arenaDupla;
    }

    public Ativacoes getAtivacoes() {
        return ativacoes;
    }

    public void setAtivacoes(Ativacoes ativacoes) {
        this.ativacoes = ativacoes;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public InsufficientResourcesException getInsufficientResourcesException() {
        return insufficientResourcesException;
    }

    public void setInsufficientResourcesException(InsufficientResourcesException insufficientResourcesException) {
        this.insufficientResourcesException = insufficientResourcesException;
    }

    public Invetario getInventario() {
        return inventario;
    }

    public void setInventario(Invetario inventario) {
        this.inventario = inventario;
    }

    public IrregularDeckException getIrregularDeckException() {
        return irregularDeckException;
    }

    public void setIrregularDeckException(IrregularDeckException irregularDeckException) {
        this.irregularDeckException = irregularDeckException;
    }

    public Lobby getLobby() {
        return lobby;
    }

    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public PasseComum getPasseComum() {
        return passeComum;
    }

    public void setPasseComum(PasseComum passeComum) {
        this.passeComum = passeComum;
    }

    public PassePremuim getPassePremium() {
        return passePremium;
    }

    public void setPassePremium(PassePremuim passePremium) {
        this.passePremium = passePremium;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Progresso getProgresso() {
        return progresso;
    }

    public void setProgresso(Progresso progresso) {
        this.progresso = progresso;
    }

    public TimeoutException getTimeoutException() {
        return timeoutException;
    }

    public void setTimeoutException(TimeoutException timeoutException) {
        this.timeoutException = timeoutException;
    }

    public TipoCarta getTipoCarta() {
        return tipoCarta;
    }

    public void setTipoCarta(TipoCarta tipoCarta) {
        this.tipoCarta = tipoCarta;
    }

    public TipoHabilidade getTipoHabilidade() {
        return tipoHabilidade;
    }

    public void setTipoHabilidade(TipoHabilidade tipoHabilidade) {
        this.tipoHabilidade = tipoHabilidade;
    }

    public UniqueCarta getUniqueCarta() {
        return uniqueCarta;
    }

    public void setUniqueCarta(UniqueCarta uniqueCarta) {
        this.uniqueCarta = uniqueCarta;
    }

    public Usario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usario usuario) {
        this.usuario = usuario;
    }

    public GameView getGameView() {
        return gameView;
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }


    public void inicializarJogo() {
        view.mostrarMensagemInicial();
        arena.iniciarPartida();

        // adiconar mais operações se for necessário
    }

    public void realizarJogada() {
     
    }
}
