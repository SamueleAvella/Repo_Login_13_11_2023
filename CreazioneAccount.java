import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CreazioneAccount {
    private Map<String, Integer> mappaUsername = new HashMap<>();
    private List<Utente> listaUtenti = new ArrayList<>();


    //registra un nuovo utente con hashing della password

    public void registraUtente(String nome, String cognome, String email, String nome_utente, String password){

        if(!verificaUnicitaUsername(nome_utente)){
            System.out.println("Username già esistente. Scegli un altro username.");
            return;
        }
        //dovrebbe generare il salt ma non riesco a importare la libreria
        //quindi devo trovare un modo diverso
        String salt = generaSalt();

        // Genera l'hash della password con il salt utilizzando SHA-256
        String hashPassword = generaHashPassword(password, salt);

        Utente u1 = new Utente(nome, cognome, email, nome_utente, password);
        //memorizza l'ID dell'utente e la posizione nell'ArrayList nella mappa
        int idUtente = listaUtenti.size();
        mappaUsername.put(nome_utente, idUtente);
    
        //aggiungi l'utente all'ArrayList
        listaUtenti.add(u1);

        System.out.println("Registrazione riuscita. Benvenuto, " + nome_utente + "!");

    }
     //verifica l'unicità dell'username
     private boolean verificaUnicitaUsername(String nome_utente) {
        if (mappaUsername.containsKey(nome_utente)) {
            return false;
        }
        return true;
    }

    // Metodo per generare un nuovo salt (implementazione di base)
    private String generaSalt() {
        // Puoi implementare questa funzione in base alle tue esigenze
        // Per ora, restituiamo una stringa casuale
        return "salt-casuale";
    }
    
    // Metodo per generare l'hash della password utilizzando SHA-256
    private String generaHashPassword(String password, String salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String passwordWithSalt = password + salt;
            byte[] hashBytes = digest.digest(passwordWithSalt.getBytes());

            // Converte il risultato in una rappresentazione esadecimale
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
