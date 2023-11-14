import java.time.LocalDate;

public class Utente {
    private String nome;
    private String cognome;
    private String email;
    private String nomeUtente;
    private String password;
    private LocalDate dataNascita;
    private String residenza;
    private Genere sesso;

    public Utente(String nome, String cognome, String email, String nomeUtente, String password) {
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.nomeUtente=nomeUtente;
        this.password=password;
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public String getEmail() {
        return email;
    }
    public String getNomeUtente() {
        return nomeUtente;
    }
    public String getPassword() {
        return password;
    }
    public LocalDate getDataNascita() {
        return dataNascita;
    }
    public String getResidenza() {
        return residenza;
    }
    public Genere getSesso() {
        return sesso;

    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }
    public void setSesso(Genere sesso) {
        this.sesso = sesso;
    }
    
    
}
