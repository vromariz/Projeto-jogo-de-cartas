import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;

public class Usuario {
    private String user;
    private String cpf;
    private String senha;
    private int idade;
    private char sexo;
    private String email;
    private int nivel = 1;
    private int saldoCardCoins = 0;
    private static Inventario inventario;
    private ArrayList<Deck> decks;

    public Usuario(String user, String cpf, String senha, int idade, char sexo, String email, Inventario inventario, ArrayList<Deck> decks) {
        JSONObject jo = new JSONObject();
        JSONParser parser = new JSONParser();
        this.user = user;
        jo.put("user", user);
        this.cpf = cpf;
        jo.put("cpf", cpf);
        this.senha = senha;
        jo.put("senha", senha);
        this.idade = idade;
        jo.put("idade", idade);
        this.sexo = sexo;
        jo.put("sexo", sexo);
        this.email = email;
        jo.put("email", email);
        Usuario.inventario = inventario;
        jo.put("inventario", inventario);
        this.decks = decks;
        jo.put("decks", decks);

        try {
            FileWriter file = new FileWriter("./output.json");
            file.write(jo.toJSONString());
            file.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double getSaldoCardCoins() {
        return saldoCardCoins;
    }

    public void setSaldoCardCoins(int saldoCardCoins) {
        this.saldoCardCoins = saldoCardCoins;
    }

    public static Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        Usuario.inventario = inventario;
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public void setDecks(ArrayList<Deck> decks) {
        this.decks = decks;
    }

    public void decrementarCardCoins(int preco) {
    }
}