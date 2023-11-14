import java.time.LocalDate;

class Utente{

    private String username;
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;

    private Utente(String nome, String cognome, LocalDate dataNascita, String username, String password, String email){
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Utente(String username, String password, String email){
        this.nome = "";
        this.cognome = "";
        this.dataNascita = null;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getCognome() {
        return cognome;
    }
    public LocalDate getDataNascita() {
        return dataNascita;
    }
    public String getEmail() {
        return email;
    }
    public String getNome() {
        return nome;
    }
    /*public String getPassword() {
        return password;
    }*/
    public String getUsername() {
        return username;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }public void setEmail(String email) {
        this.email = email;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
   /*public void setPassword(String password) {
        this.password = password;
    }*/

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " " + cognome + "\n" +
                "Data Nascita: " + dataNascita + "\n" +
                "email: " + email + " username: " + username + "\n";
    }
    


}