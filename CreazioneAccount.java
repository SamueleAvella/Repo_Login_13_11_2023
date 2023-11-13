import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CreazioneAccount {
    private Map<String, Integer> mappaUsername = new HashMap<>();
    private List<Utente> listaUtenti = new ArrayList<>();


    //registra un nuovo utente con hashing della password

    private void registraUtente(String nome, String cognome, String email, String nome_utente, String password){

        if(!verificaUnicitaUsername(nome_utente)){
            System.out.println("Username già esistente. Scegli un altro username.");
            return;
        }
        //dovrebbe generare il salt ma non riesco a importare la libreria
        //quindi devo trovare un modo diverso
        String salt = BCrypt.gensalt();

        //Calcola l'hash della password con il salt
        String hashPassword = BCrypt.hashpw(password, salt);

        Utente u1 = new Utente(nome, cognome, email, nome_utente, hashPassword);
        //memorizza l'ID dell'utente e la posizione nell'ArrayList nella mappa
        int idUtente = listaUtenti.size();
        mappaUsername.put(nome_utente, idUtente);
    
        //aggiungi l'utente all'ArrayList
        listaUtenti.add(u1);

    }
     //verifica l'unicità dell'username
     private boolean verificaUnicitaUsername(String nome_utente) {
        if (mappaUsername.containsKey(nome_utente)) {
            return false;
        }
        return true;
    }

    
}
