public class Utente {
    String nome;
    String cognome;
    String email;
    String nome_utente;
    String hashPassword;

    public Utente(String nome, String cognome, String email, String nome_utente, String hashPassword) {
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.nome_utente=nome_utente;
        this.hashPassword=hashPassword;
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
    public String getNome_utente() {
        return nome_utente;
    }
    public String getHashPassword() {
        return hashPassword;
    }
    /*public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNome_utente(String nome_utente) {
        this.nome_utente = nome_utente;
    }
    public void setPassword(String hashgPassword) {
        this.hashPassword = hashPassword;
    }
    @Override
    public String toString() {
        String descrizione ="";
        descrizione+= "Nome: "+ this.nome;
        descrizione+= "Cognome: "+ this.cognome;
        descrizione+= "Email: "+ this.email;
        descrizione+= "Nome utente: "+ this.nome_utente;
        descrizione+= "Password segreta :)";
        return descrizione;
    }*/
}
