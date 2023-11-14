import java.time.LocalDate;

class CreazioneAccount {

    public static boolean registraUtente(String username, String password, String email) {

        //FARE HASHING PASSWORD E AGGIUNGERLO ALL'ARRAY LIST
        UserManager.addUser(new Utente(username,  password, email));
        return true;
    }

}
