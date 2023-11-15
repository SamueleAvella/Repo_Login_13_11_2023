
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CreazioneAccount {
 
    //private static List<Map> listaUtenti = new ArrayList<>();
    //registra un nuovo utente con hashing della password

    public boolean registraUtente(String nome, String cognome, String email, String nomeUtente, String password){
        
        Map <String, String> nuovaMappa = new HashMap<>();
        if (nome.equals("")|| cognome.equals("") || email.equals("")|| nomeUtente.equals("") || password.equals("")) {
            System.out.println("Tutti i campi devono essere compilati. Riprova.");
            return false;
        }
        else if (password.length() < 8) {
            System.out.println("La password deve contenere almeno 8 caratteri. Riprova.");
            return false;
        }
        else if(UserManager.isContainedByUser(nomeUtente)){
            System.out.println("Username già esistente. Scegli un altro username.");
            return false;
        }
        else{           //devo aggiustare un controllo perché salva anche se l'username è lo stesso
                        //dovrebbe generare il salt
        String salt = generaSalt();
                        // Genera l'hash della password con il salt utilizzando SHA-256
        String hashPassword = generaHashPassword(password, salt);

        nuovaMappa.put("nome", nome);
        nuovaMappa.put("cognome", cognome);
        nuovaMappa.put("email", email);
        nuovaMappa.put("username", nomeUtente);
        nuovaMappa.put("hashpasword", hashPassword);
          
        //aggiungi l'utente all'ArrayList
        //listaUtenti.add(nuovaMappa);
        UserManager.addUser(nuovaMappa);
        System.out.println("Registrazione riuscita. Benvenuto/a, " + nomeUtente + "!");

        return true;
        }
    }


     //verifica l'unicità dell'username

    // Metodo per generare un nuovo salt (implementazione di base)
    private String generaSalt() {
        // Puoi implementare questa funzione in base alle tue esigenze
        // Per ora, restituiamo una stringa casuale
        return "salt-casuale";
    }
    
    // Metodo per generare l'hash della password utilizzando SHA-256
    static String generaHashPassword(String password, String salt) {

        System.out.println("Generazione...");
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
