
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CreazioneAccount {
    private Map<String, Integer> mappaUsername = new HashMap<>();
    //private List<Utente> listaUtenti = new ArrayList<>();
    

    //registra un nuovo utente con hashing della password

    public boolean registraUtente(String nome, String cognome, String email, String nomeUtente, String password){


           // Controllo di nullità per i dati inseriti
           if (nome == null || cognome == null || email == null || nomeUtente == null || password == null) {
            System.out.println("Tutti i campi devono essere compilati. Riprova.");
            return false;
        }

        // Controllo lunghezza della password
        if (password.length() < 8) {
            System.out.println("La password deve contenere almeno 8 caratteri. Riprova.");
            return false;
        }

        if(!verificaUnicitaUsername(nomeUtente)){
            System.out.println("Username già esistente. Scegli un altro username.");
            return false;
        }else{
        //genera il salt 
        String salt = generaSalt();

        //genera l'hash della password con il salt utilizzando SHA-256
        String hashPassword = generaHashPassword(password, salt);

        //la grandezza dell'arraylist si autoincrementa ogni volta
        //che si aggiunge un utente quindi l'id dell'utente corrisponde
        //alla sua posizione all'interno della lista
 
        int idUtente = UserManager.getSizeList();
        //salviamo i dati nella mappa
        mappaUsername.put(nomeUtente, idUtente);
    
        //aggiungi l'utente all'ArrayList
        //listaUtenti.add(new Utente(nome, cognome, email, nomeUtente, hashPassword));

        //controlli
        //if(nome!=null && cognome!=null, && email!=null && nomeUtente!=null)
        UserManager.addUser(new Utente(nome, cognome, email, nomeUtente, hashPassword));

        System.out.println("Registrazione riuscita. Benvenuto/a, " + nomeUtente + "!");

        return true;
        }
    }
     //verifica l'unicità dell'username
     private boolean verificaUnicitaUsername(String nomeUtente) {
        if (mappaUsername.containsKey(nomeUtente)) {
            return false;
        }
        return true;
    }

    //metodo per generare un nuovo salt (implementazione di base)
    private String generaSalt() {
        // è modificabile in base alle esigenze
        //per ora, restituisce una stringa casuale
        return "salt-casuale";
    }
    
    //metodo per generare l'hash della password utilizzando SHA-256
    private String generaHashPassword(String password, String salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String passwordWithSalt = password + salt;
            byte[] hashBytes = digest.digest(passwordWithSalt.getBytes());

            //converte il risultato in una rappresentazione esadecimale
            StringBuilder hashStringBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                hashStringBuilder.append(String.format("%02x", b));
            }

            return hashStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Errore nell'algoritmo di hashing", e);
        }
    }
    
}
