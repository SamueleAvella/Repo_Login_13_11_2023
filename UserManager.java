import java.util.ArrayList;
import java.util.List;

class UserManager{

    private static UserManager istanza;
    private static List<Utente> listaUtenti = new ArrayList<>();
    
    private UserManager(){}

    public static UserManager getInstance() {

        if (istanza == null){
            istanza = new UserManager();
        }

        return istanza;
    }

    public static void addUser(Utente utente){
        listaUtenti.add(utente);
    }

    public static boolean isContainedByUser(String user){
        for (Utente utente : listaUtenti) {
            if(utente.getUsername().equalsIgnoreCase(user))
                return true;
        }
        return false;
    }

    /*public void removeUser(Utente utente){
        listaUtenti.remove(utente);
    }*/



}


