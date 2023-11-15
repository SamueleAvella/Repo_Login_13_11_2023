import java.time.LocalDate;

/*public class Main {
    public static void main(String[] args) {
        
        //INIZIALIZZAZIONI VARIABILI D'APPOGGIO
        String  user="", 
                psw="", 
                nome="", 
                cognome="", 
                email="";
        LocalDate dataNascita;

        Sessione.getInstance(); //CREA UNA SESSIONE

        if (Sessione.getUserLogged()==null) {

            //REGISTRAZIONE
            CreazioneAccount.registraUtente(nome, cognome, email, nomeUtente, password);
    
            //TORNA ALL'HOMPAGE
            //ACCEDI

            Login.effettuaLogin(user, psw);
        }
        else{
            Options opzione=Options.CHANGE_PSW;

            Sessione.operation(opzione);
        }
*/

public class Main {
    public static void main(String[] args) {
        // Creazione di un'istanza della classe CreazioneAccount
        CreazioneAccount creazioneAccount = new CreazioneAccount();

        // Esempio di registrazione di un nuovo utente
        creazioneAccount.registraUtente("John", "Doe", "john.doe@example.com", "jon", "password123");

        // Esempio di tentativo di registrazione con username già esistente
        creazioneAccount.registraUtente("Jane", "Doe", "jane.doe@example.com", "john_doe", "anotherpassword");

        // Esempio di registrazione di un altro utente
        creazioneAccount.registraUtente("Alice", "Smith", "alice.smith@example.com", "alice", "securepassword");

        creazioneAccount.registraUtente("", "Smith", "alice.smith@example.com", "alice", "securepassword");
        creazioneAccount.registraUtente("Alice", "Smith", "alice.smith@example.com", "alice", "secur");

        System.out.println((Login.effettuaLogin("jon", "password123")) ? "Login Effettuato" : "Login Non effettuato");

        //UserManager.stampaUtenti();

        System.out.println("Cambio password. ");
        Sessione.operation(Options.CHANGE_PSW);

        System.out.println((Login.effettuaLogin("jon", "password123")) ? "Login Effettuato" : "Login Non effettuato");

        System.out.println("Crud create. ");
        Sessione.operation(Options.CREATE);

        UserManager.stampaUtenti();

        System.out.println("Crud read. ");
        Sessione.operation(Options.READ);

        System.out.println("Crud update. ");
        Sessione.operation(Options.UPDATE);

        System.out.println("Crud delete. ");
        Sessione.operation(Options.DELETE);

        UserManager.stampaUtenti();


    }
}

